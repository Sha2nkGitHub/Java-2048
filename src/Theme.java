import java.awt.*;
import java.util.Map;
import java.util.HashMap;

public class Theme {
    public static final Color PANEL_BACKGROUND = new Color(194, 186, 171);
    public static final Color FRAME_BACKGROUND = new Color(232, 225, 213);
    public static final Color TILE_FOREGROUND = new Color(84, 80, 73);
    public static final Font TILE_FONT = new Font("Clear sans", Font.BOLD, 45);
    public static final int TILE_SIZE = 120;
    public static final int TILE_GAP = 15;

    public static final Map<Integer, Color> TILE_BACKGROUND_COLOR_MAP;
    static {
        TILE_BACKGROUND_COLOR_MAP = new HashMap<>();
        TILE_BACKGROUND_COLOR_MAP.put(0, new Color(156, 146, 137));
        TILE_BACKGROUND_COLOR_MAP.put(2, new Color(232, 219, 209));
        TILE_BACKGROUND_COLOR_MAP.put(4, new Color(230, 215, 190));
        TILE_BACKGROUND_COLOR_MAP.put(8, new Color(232, 160, 97));
        TILE_BACKGROUND_COLOR_MAP.put(16, new Color(237, 142, 90));
        TILE_BACKGROUND_COLOR_MAP.put(32, new Color(237, 113, 88));
        TILE_BACKGROUND_COLOR_MAP.put(64, new Color(250, 100, 70));
        TILE_BACKGROUND_COLOR_MAP.put(128, new Color(230, 205, 117));
        TILE_BACKGROUND_COLOR_MAP.put(256, new Color(47, 245, 106));
        TILE_BACKGROUND_COLOR_MAP.put(512, new Color(10, 188, 252));
        TILE_BACKGROUND_COLOR_MAP.put(1024, new Color(242, 255, 0));
        TILE_BACKGROUND_COLOR_MAP.put(2048, new Color(255, 0, 0));
    }

    public static final Font SCORELABEL_FONT = new Font("Ink Free", Font.BOLD, 32);
    public static final Color SCORELABEL_COLOR = Color.RED;
}
