export class Board {
    constructor() {
        this.element = $(".board");
    }

    append = element => {
        this.element.append(element);
    };
}
