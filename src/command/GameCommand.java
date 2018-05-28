package command;

import org.newdawn.slick.command.Command;

/**
 * Enum class for the game command
 */
public enum GameCommand implements Command {
    STARTPAGE, INVENTORY, NONE, STATSPLAYER, PAUSE, ADDLIFE, ADDMANA,
    ADDPHYSICALATK, ADDFIREATK, ADDICEATK, ADDEARTHATK, ADDPHYSICALRES, ADDFIRERES, ADDICERES, ADDEARTHRES
}
