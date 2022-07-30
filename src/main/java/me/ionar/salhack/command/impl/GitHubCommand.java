package me.ionar.salhack.command.impl;

import me.ionar.salhack.command.Command;

public class GitHubCommand extends Command {

    public GitHubCommand()
    {
        super("GitHub", "Sends GitHub link.");
    }

    @Override
    public void ProcessCommand(String p_Args) {
        String[] l_Split = p_Args.split(" ");

        if (l_Split == null || l_Split.length <= 1) {
            mc.player.sendChatMessage("https://github.com/CreepyOrb924/creepy-salhack/releases");
            return;
        }
    }

    @Override
    public String GetHelp()
    {
        return "Sends the Creepy-SalHack GitHub link to chat.";
    }

}
