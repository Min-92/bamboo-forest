export class Form {
    constructor(send) {
        this.formElement = $(".shout_form");
        this.submitElement = $(".submit");
        this.textAreaElement = $(".text_area");
        this.send = send;
        this.init();
    }

    init = () => {
        this.addSubmitEvent();
    };

    addSubmitEvent = () => {
        this.formElement.on("submit", event => {
            event.preventDefault();
            this.submit();
        });
    };

    submit = () => {
        this.send(this.textAreaElement.val());
        this.textAreaElement.val("");
    };
}
