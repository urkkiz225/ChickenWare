package me.ionar.salhack.module.chat;

import me.ionar.salhack.events.player.EventPlayerSendChatMessage;
import me.ionar.salhack.module.Module;
import me.ionar.salhack.module.Value;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.network.play.client.CPacketChatMessage;


import java.util.Objects;

public class MessageModifierModule extends Module{

    public static final Value<Boolean> Suffix = new Value<Boolean>("Suffix", new String[] {"Suffix"}, "Adds a message to the end of your sentences.", false);
    public final Value<SeparatorMode> Mode = new Value<SeparatorMode>("Separator", new String[] {""}, "Separator used for suffix.", SeparatorMode.Classic);
    public final Value<SuffixMode> SuffixModes = new Value<SuffixMode>("SuffixFont", new String[] {""}, "Font used for suffix.", SuffixMode.SuperScript);
    public static final Value<Boolean> ColorChat = new Value<Boolean>("ColorChat", new String[] {"ColorChat"}, "Makes chat colorful on servers with support.", false);
    public final Value<ColorModes> ColorMode = new Value<ColorModes>("ColorChatMode", new String[] {"M"}, "Color mode.", ColorModes.Green);
    public static final Value<Boolean> FancyChat = new Value<Boolean>("FancyChat", new String[] {"FancyChat"}, "Makes your chat message fancy.", false);
    public final Value<FancyChatModes> FancyChatMode = new Value<FancyChatModes>("FancyChatMode", new String[] {"FancyChatMode"}, "Mode for fancy chat.", FancyChatModes.Circle);
    public static final Value<Boolean> Wheelchair = new Value<Boolean>("Wheelchair", new String[] {"Wheelchair"}, "Adds a wheelchair to the beginning of your messages.", false);
    public static final Value<Boolean> TM = new Value<Boolean>("TradeMark", new String[] {"TM"}, "Adds TM to the end of your messages.", false);


    public enum ColorModes {
        Green,
        Blue,
    }

    public enum SuffixMode {
        SuperScript,
    }

    public enum SeparatorMode
    {
        Classic,
        Arrow,
    }

    public enum FancyChatModes
    {
        Circle,
        UwU,
        Classic,
    }

    public MessageModifierModule()
    {
        super("MessageModifier", new String[]
                        { "MessageModifier" }, "Modifies the messages you send to chat.", "NONE",
                0xDB2485, Module.ModuleType.CHAT);
    }

    public String setSuffix = "chickenWare";

    @EventHandler
    private final Listener<EventPlayerSendChatMessage> OnSendChatMsg = new Listener<>(p_Event ->
    {
        if (p_Event.Message.startsWith("/") || p_Event.Message.startsWith("*") || p_Event.Message.startsWith("-") || p_Event.Message.startsWith("#") || p_Event.Message.startsWith("$") || p_Event.Message.startsWith("^") || p_Event.Message.startsWith(";") || p_Event.Message.startsWith(".") || p_Event.Message.startsWith("&") || p_Event.Message.startsWith(",") || p_Event.Message.startsWith("!"))
            return;

        String suffix = "chickenWare";
        String l_Message = p_Event.Message;
        String total_Message;


       if(FancyChat.getValue()) {
           switch (FancyChatMode.getValue()) {
               case Circle:
                    l_Message = convertToUCircle(l_Message.toLowerCase());
                   break;
               case UwU:
                   //Thanks to Osiris for this UwU bit.
                   l_Message = l_Message.replace("l", "w").replace("ll", "ww").replace("r", "w").replace("R", "W") + " UwU";
                   suffix = "uwu creepy-salhack";
                   break;
               case Classic:
                   l_Message = fancy(l_Message);
           }
       }

        //FancyChatMode.getValue() != FancyChatModes.UwU ? suffix = "creepy-salhack";

        if(ColorChat.getValue() && Suffix.getValue() && Wheelchair.getValue() && TM.getValue())
            total_Message = getChatColor() + "\u267F" + l_Message + "\u2122" + getSeparatorMode() + convertToUnicode(suffix);
         else if (ColorChat.getValue() && Suffix.getValue() && Wheelchair.getValue())
            total_Message = getChatColor() + "\u267F" + l_Message + getSeparatorMode() + convertToUnicode(suffix);
         else if(ColorChat.getValue() && Suffix.getValue() && TM.getValue())
            total_Message = getChatColor() + l_Message + "\u2122" + getSeparatorMode() + convertToUnicode(suffix);
         else if (ColorChat.getValue() && Suffix.getValue())
            total_Message = getChatColor() + l_Message + getSeparatorMode() + convertToUnicode(suffix);
         else if (Suffix.getValue() && Wheelchair.getValue() && TM.getValue())
            total_Message = "\u267F" + l_Message + "\u2122" + getSeparatorMode() + convertToUnicode(suffix);
         else if (Suffix.getValue() && Wheelchair.getValue())
            total_Message = "\u267F" + l_Message + getSeparatorMode() + convertToUnicode(suffix);
         else if(Suffix.getValue() && TM.getValue())
            total_Message = l_Message + "\u2122" + getSeparatorMode() + convertToUnicode(suffix);
         else if (Suffix.getValue())
            total_Message =  l_Message + getSeparatorMode() + convertToUnicode(suffix);
         else if (ColorChat.getValue() && Wheelchair.getValue() && TM.getValue())
            total_Message = getChatColor() + "\u267F" + l_Message + "\u2122";
         else if (ColorChat.getValue() && Wheelchair.getValue())
            total_Message = getChatColor() + "\u267F" + l_Message;
         else if (ColorChat.getValue() && TM.getValue())
            total_Message = getChatColor() + l_Message + "\u2122";
         else if (ColorChat.getValue())
            total_Message = getChatColor() + l_Message;
         else if (Wheelchair.getValue() && TM.getValue())
            total_Message = "\u267F" + l_Message + "\u2122";
         else if (Wheelchair.getValue())
        total_Message = "\u267F" + l_Message;
         else if (TM.getValue())
            total_Message = l_Message + "\u2122";
         else
            return;

        p_Event.cancel();

        if (total_Message.length() >= 256) {
            total_Message = total_Message.substring(0, 256);
        }

        Objects.requireNonNull(mc.getConnection()).sendPacket(new CPacketChatMessage(total_Message));
    });

    //Thanks to boap for this bit.
    private String convertToUnicode(String base) {
        String new_base;
            new_base = base.replace("a", "\u1d00");
            new_base = new_base.replace("b", "\u0299");
            new_base = new_base.replace("c", "\u1d04");
            new_base = new_base.replace("d", "\u1d05");
            new_base = new_base.replace("e", "\u1d07");
            new_base = new_base.replace("f", "\u0493");
            new_base = new_base.replace("g", "\u0262");
            new_base = new_base.replace("h", "\u029c");
            new_base = new_base.replace("i", "\u026a");
            new_base = new_base.replace("j", "\u1d0a");
            new_base = new_base.replace("k", "\u1d0b");
            new_base = new_base.replace("l", "\u029f");
            new_base = new_base.replace("m", "\u1d0d");
            new_base = new_base.replace("n", "\u0274");
            new_base = new_base.replace("o", "\u1d0f");
            new_base = new_base.replace("p", "\u1d18");
            new_base = new_base.replace("q", "\u01eb");
            new_base = new_base.replace("r", "\u0280");
            new_base = new_base.replace("s", "\u0455");
            new_base = new_base.replace("t", "\u1d1b");
            new_base = new_base.replace("u", "\u1d1c");
            new_base = new_base.replace("v", "\u1d20");
            new_base = new_base.replace("w", "\u1d21");
            new_base = new_base.replace("x", "\u0445");
            new_base = new_base.replace("y", "\u028f");
            new_base = new_base.replace("z", "\u1d22");
            new_base = new_base.replace("0", "\u2080");
            new_base = new_base.replace("1", "\u2081");
            new_base = new_base.replace("2", "\u2082");
            new_base = new_base.replace("3", "\u2083");
            new_base = new_base.replace("4", "\u2084");
            new_base = new_base.replace("5", "\u2085");
            new_base = new_base.replace("6", "\u2086");
            new_base = new_base.replace("7", "\u2087");
            new_base = new_base.replace("8", "\u2088");
            new_base = new_base.replace("9", "\u2089");
            return new_base;
    }

    private String convertToUCircle(String base) {
        String new_base;
            new_base = base.replace("a", "\u24b6");
            new_base = new_base.replace("b", "\u24b7");
            new_base = new_base.replace("c", "\u24b8");
            new_base = new_base.replace("d", "\u24b9");
            new_base = new_base.replace("e", "\u24ba");
            new_base = new_base.replace("f", "\u24bb");
            new_base = new_base.replace("g", "\u24bc");
            new_base = new_base.replace("h", "\u24bd");
            new_base = new_base.replace("i", "\u24be");
            new_base = new_base.replace("j", "\u24bf");
            new_base = new_base.replace("k", "\u24c0");
            new_base = new_base.replace("l", "\u24c1");
            new_base = new_base.replace("m", "\u24c2");
            new_base = new_base.replace("n", "\u24c3");
            new_base = new_base.replace("o", "\u24c4");
            new_base = new_base.replace("p", "\u24c5");
            new_base = new_base.replace("q", "\u24c6");
            new_base = new_base.replace("r", "\u24c7");
            new_base = new_base.replace("s", "\u24c8");
            new_base = new_base.replace("t", "\u24c9");
            new_base = new_base.replace("u", "\u24ca");
            new_base = new_base.replace("v", "\u24cb");
            new_base = new_base.replace("w", "\u24cc");
            new_base = new_base.replace("x", "\u24cd");
            new_base = new_base.replace("y", "\u24ce");
            new_base = new_base.replace("z", "\u24cf");
            new_base = new_base.replace("0", "\u24ea");
            new_base = new_base.replace("1", "\u2460");
            new_base = new_base.replace("2", "\u2461");
            new_base = new_base.replace("3", "\u2462");
            new_base = new_base.replace("4", "\u2463");
            new_base = new_base.replace("5", "\u2464");
            new_base = new_base.replace("6", "\u2465");
            new_base = new_base.replace("7", "\u2466");
            new_base = new_base.replace("8", "\u2467");
            new_base = new_base.replace("9", "\u2468");
        return new_base;
    }

    private String getSeparatorMode() {
        String returnString;
        switch (Mode.getValue()) {
            case Classic:
                returnString = " \u23d0 ";
                break;
            case Arrow:
                returnString = " \u00BB ";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + Mode.getValue());
        }
        return returnString;
    }
    
    private String getChatColor() {
        String returnValue;
        switch (ColorMode.getValue()) {
            case Green:
                returnValue = ">";
                break;
            case Blue:
                returnValue = "'";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + ColorMode.getValue());
        }
        return returnValue;
    }

    private String fancy(String input) {
        final StringBuilder sb = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (c >= 0x21 && c <= 0x80) {
                sb.append(Character.toChars(c + 0xFEE0));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
