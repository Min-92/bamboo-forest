export class Shout {
    constructor(data) {
        this.content = data.content;
        this.id = data.id;
        //time, xposition 추가
    }

    toElement = () => {
        const shoutElement = document.createElement("div");
        $(this.element).addClass("shout");

        const contentElement = document.createElement("p");
        contentElement.append(this.content);
        shoutElement.append(contentElement);
        //시간, position 으로 style부여

        return shoutElement;
    };
}
