import { Shout } from "../components/shout.js";

export class Websocket {
    constructor() {
        this.SOCKET_ENDPOINT = "/websocket";
        this.socket = new SockJS(this.SOCKET_ENDPOINT);
        this.stompClient = Stomp.over(this.socket);
        this.connected = false;
    }

    connect = addShout => {
        // 연결 실패 처리
        this.stompClient.connect({}, () => {
            this.connected = true;
            this.subscribe(addShout);
        });

        return this.connected;
    };

    subscribe = addShout => {
        this.stompClient.subscribe("/topic/shouts", response => {
            const shoutData = JSON.parse(response.body);
            addShout(new Shout(shoutData));
        });
    };

    send = content => {
        this.stompClient.send("/app/shouts", {}, JSON.stringify({ content }));
    };
}
