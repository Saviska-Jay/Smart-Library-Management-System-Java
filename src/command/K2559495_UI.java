package command;

public class K2559495_UI 
{
    private K2559495_Command command;

    public void setCommand(K2559495_Command command) 
    {
        this.command = command;
    }

    public void pressButton() 
    {
        command.execute();
    }
}