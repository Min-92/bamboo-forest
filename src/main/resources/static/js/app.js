import { Websocket } from "./utils/websocket.js";
import { Form } from "./components/form.js";
import { Shout } from "./components/shout.js";
import { Board } from "./components/board.js";

class App {
    constructor() {
        this.websocket = new Websocket(this.addShout);
        this.form = new Form(this.websocket.send);
        this.board = new Board();
    }

    start = async () => {
        await this.init();

        this.websocket.connect();
    };

    init = async () => {
        const response = await fetch("/shouts");
        const body = await response.json();

        if (!body.length) {
            return;
        }

        this.addShouts(body);
    };

    addShouts = shoutDataList => {
        shoutDataList.forEach(shoutData => {
            this.addShout(new Shout(shoutData));
        });
    };

    addShout = shout => {
        this.board.append(shout.toElement());
        // 외침 사라지는 이벤트 추가
    };
}

$(document).ready(() => {
    const app = new App();
    app.start();
});
