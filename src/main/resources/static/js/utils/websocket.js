import { Shout } from "../components/shout.js";

export class Websocket {
    constructor(addShout) {
        this.SOCKET_ENDPOINT = "/websocket";
        this.socket;
        this.stompClient;

        this.connected = false;
        this.addShout = addShout;
    }

    connect = () => {
        this.socket = new SockJS(this.SOCKET_ENDPOINT);
        this.stompClient = Stomp.over(this.socket);
        this.stompClient.reconnect_delay = 100;

        this.stompClient.connect({}, this.success, this.failure);
    };

    success = () => {
        this.connected = true;
        this.subscribe();
    };

    failure = () => {
        this.connected = false;
        this.success();
    };

    subscribe = () => {
        this.stompClient.subscribe("/topic/shouts", response => {
            const shoutData = JSON.parse(response.body);
            this.addShout(new Shout(shoutData));
        });
    };

    send = content => {
        this.stompClient.send("/app/shouts", {}, JSON.stringify({ content }));
    };
}
