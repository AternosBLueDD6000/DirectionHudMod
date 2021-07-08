package BLueDD.hud.mod.impl;

import BLueDD.hud.mod.HudMod;
import BLueDD.mod.Mod;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class DirectionMod extends HudMod{
	
	protected static ScaledResolution scaledResolution;
    public static String markerColor = "c";
    public static int compassIndex = 0;

	public DirectionMod() {
		super("Direction", 90, 8);
		
	}

	@Override
	public int getWidth() {
		return 102;
	}

	@Override
	public int getHieght() {
		return 15;
	}
	
	@Override
	public void draw() {
		if(Mod.getModPusula().isEnabled()) {
	        int direction = MathHelper.floor_double((double) (mc.thePlayer.rotationYaw * 256.0F / 360.0F) + 0.5D) & 255;
	        int yBase = getY(1, 12);
	        int xBase = getX(65);
	        
	        mc.getTextureManager().bindTexture(new ResourceLocation("BLueDD/pics/Pusula.png"));
	        if (direction < 128) {
	        	Gui.drawTexturedModalRect(drag.getxPosition() + xBase - 64, drag.getyPosition() + yBase - 10, direction, this.compassIndex * 24, 100, 13);
	        } else {
	            Gui.drawTexturedModalRect(drag.getxPosition() + xBase - 64, drag.getyPosition() + yBase - 10, direction - 128, this.compassIndex * 24 + 12, 100, 13);
	        }

	        mc.fontRendererObj.drawString("§" + this.markerColor.toLowerCase() + "|§r", drag.getxPosition() + xBase - 16, drag.getyPosition() + yBase - 7, 16777215);
	        super.draw();
	        }
		
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		if(Mod.getModPusula().isEnabled()) {
	        int direction = MathHelper.floor_double((double) (mc.thePlayer.rotationYaw * 256.0F / 360.0F) + 0.5D) & 255;
	        int yBase = getY(1, 12);
	        int xBase = getX(65);
	        
	        mc.getTextureManager().bindTexture(new ResourceLocation("BLueDD/pics/Pusula.png"));
	        if (direction < 128) {
	        	Gui.drawTexturedModalRect(drag.getxPosition() + xBase - 64, drag.getyPosition() + yBase - 10, direction, this.compassIndex * 24, 100, 13);
	        } else {
	            Gui.drawTexturedModalRect(drag.getxPosition() + xBase - 64, drag.getyPosition() + yBase - 10, direction - 128, this.compassIndex * 24 + 12, 100, 13);
	        }

	        mc.fontRendererObj.drawString("§" + this.markerColor.toLowerCase() + "[Direction Hud]§r", drag.getxPosition() + xBase - 16, drag.getyPosition() + yBase - 7, 16777215);
	        super.renderDummy(mouseX, mouseY);
	        }
		}
		
	    private static int getX(int width) {
			return width;
	    }

	    private static int getY(int rowCount, int height) {
	        return height;
	    }
	    
	    public static enum Direction {
	        S,
	        SW,
	        W,
	        NW,
	        N,
	        NE,
	        E,
	        SE;
	     }
	
}

