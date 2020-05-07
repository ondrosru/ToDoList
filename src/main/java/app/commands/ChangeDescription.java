package app.commands;

import app.domains.deal.IDeal;

public class ChangeDescription implements Command {
    private IDeal deal;
    private String description;

    public ChangeDescription(IDeal deal, String description) {
        this.deal = deal;
        this.description = description;
    }


    @Override
    public void execute() {
        deal.setDescription(description);
    }
}
