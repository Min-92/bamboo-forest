export class Shout {
    constructor(data) {
        this.content = data.content;
        this.id = data.id;
        this.createdDateTime = data.createdDateTime;
        this.xPosition = data.xposition;
        this.yPosition = data.yposition;
        this.fontIndex = data.fontIndex;
        this.TIME_TO_LIVE = 60000;
        this.remainingTime =
            this.TIME_TO_LIVE -
            (Date.now() - new Date(this.createdDateTime).getTime());
        this.element;
    }

    toElement = () => {
        this.element = $(document.createElement("div"));
        $(this.element).addClass("shout");

        const contentElement = $(document.createElement("p"));
        contentElement.append(this.content);
        this.element.append(contentElement);

        this.setPositions();
        this.setOpacity();
        this.setFont();

        return this.element;
    };

    setPositions = () => {
        const option = {};

        this.setXPosition(option);
        this.setYPosition(option);

        $(this.element).css(option);
    };

    setOpacity = () => {
        this.element.css({
            opacity: `${this.remainingTime / 60000}`,
            transition: `opacity ${this.remainingTime}ms linear`
        });
    };

    setXPosition = option => {
        if (this.xPosition <= 50) {
            option.left = `${this.xPosition}%`;
            option.transform = `translateX(-${this.xPosition}%) `;
            return;
        }

        option.right = `${100 - this.xPosition}%`;
        option.transform = `translateX(${100 - this.xPosition}%) `;
    };

    setYPosition = option => {
        if (this.yPosition <= 50) {
            option.top = `${this.yPosition}%`;
            option.transform += `translateY(-${this.yPosition}%`;
            return;
        }

        option.bottom = `${100 - this.yPosition}%`;
        option.transform += `translateY(100 -${this.yPosition}%)`;
    };

    setFont = () => {
        $(this.element).addClass(`font${this.fontIndex}`);
    };
}
