export class Board {
    constructor() {
        this.boardElement = $(".board");
    }

    append = element => {
        this.boardElement.append(element);
    };
}
