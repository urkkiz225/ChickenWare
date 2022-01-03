package me.ionar.salhack.mixin.client;

import me.ionar.salhack.SalHackMod;
import me.ionar.salhack.managers.ImageManager;
import me.ionar.salhack.managers.UpdateManager;
import me.ionar.salhack.util.imgs.SalDynamicTexture;
import me.ionar.salhack.util.render.ParticleRenderer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.world.GameType;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.awt.*;
import java.io.IOException;
import java.net.URI;

/**
 * Renders particles
 *
 * @author brudin
 * @version 1.0
 * @since 1/5/14
 * https://github.com/XxlunimexX/Huzuni-1.11
 */

@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu extends GuiScreen {

    //Setup particle renderer
    private final ParticleRenderer particleRenderer = new ParticleRenderer(width, height);

    //Call update manager
    private final UpdateManager updateManager = UpdateManager.Get();

    //Load title texture
    private SalDynamicTexture TITLE;

    /**
     * Updates the particles.
     */
    @Inject(method = "initGui", at = @At("RETURN"))
    public void setup(CallbackInfo ci) {
        TITLE = ImageManager.Get().GetDynamicTexture("Title");
        particleRenderer.updateSize(width, height);

        //buttons (larp)
        GuiButton TestButton = new GuiButton(69, this.width / 2 - 100, this.height - this.height / 8, "TestButton");
        GuiButton updateButton = new GuiButton(69, this.width / 2 - 100, this.height - this.height / 16, "ChickenWare GitHub");
        if(!updateManager.getVersion().equals("") && Double.parseDouble(updateManager.getVersion().substring(2)) > Double.parseDouble(SalHackMod.VERSION.substring(2))) {
            this.buttonList.add(updateButton);
            this.buttonList.add(TestButton);
        }
    }

    @Inject(method = "actionPerformed", at = @At("HEAD"))
    protected void actionPerformed(GuiButton button, CallbackInfo ci) throws IOException {
        if(button.id == 69) {
            Desktop.getDesktop().browse(URI.create("https://github.com/urkkiz225/ChickenWare"));
        } else {
            super.actionPerformed(button);
        }

    }

    @Inject(method = "updateScreen", at = @At("HEAD"))
    public void updatePanorama(CallbackInfo ci) {
        
    }

    /**
     * Renders the particles.
     */
    @Inject(method = "drawScreen", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/gui/GuiMainMenu;renderSkybox(IIF)V", shift = At.Shift.AFTER))
    public void replacePanoramaRenderer(int mouseX, int mouseY, float partialTicks, CallbackInfo callbackInfo) {
        
    }

    /**
     * Renders the Creepy Salhack version on the top right of the screen.
     */
    @Inject(method = "drawScreen", at = @At(value = "RETURN"))
    public void renderSalhackVersion(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        this.drawString(fontRenderer, SalHackMod.NAME + " " + SalHackMod.VERSION, width - fontRenderer.getStringWidth(SalHackMod.NAME + " " + SalHackMod.VERSION) - 2, 2, 0x3FFFFFFF);
    }

    /**
     * Removes the gradients from rendering on the menu, since we already got that covered.
     */
    @Redirect(method = "drawScreen", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/gui/GuiMainMenu;drawGradientRect(IIIIII)V"))
    public void removeGradients(GuiMainMenu guiMainMenu, int left, int top, int right,
                                int bottom, int startColor, int endColor) {
    }
    /**
     * Renders the SalHack logo.
     */
    
    @Inject(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureManager;bindTexture(Lnet/minecraft/util/ResourceLocation;)V"))
    public void removeMenuLogoInit(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        float titleX = width / 2 - 200, titleY = 10;
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();

        particleRenderer.bindTexture(TITLE, titleX, titleY, 400, 125, 0F, 0F, 1F, 1F);
        GlStateManager.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GlStateManager.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);

        GlStateManager.enableTexture2D();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);

        GlStateManager.popMatrix();
    }





    /**
     * Prevents Minecraft's logo from rendering by replacing the drawTextureModalRect methods in drawScreen to
     * nothing.
     *
     * Since drawTexturedModalRect is only used for the logo, this doesn't break anything in the vanilla menu.
     */
    @Redirect(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiMainMenu;drawTexturedModalRect(IIIIII)V"))
    public void removeMenuLogoRendering(GuiMainMenu guiMainMenu, int x, int y, int textureX, int textureY, int width, int height) {

    }

    /**
     * Changes the color of text to a more transparent and eye-pleasing color.
     *
     * This does not change the color for Forge's update alerts, which at first was a bug but after some thinking, if it
     * annoys you, just update Forge!
     */
    @Redirect(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiMainMenu;drawString(Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;III)V"))
    public void changeTextColor(GuiMainMenu guiMainMenu, FontRenderer fontRendererIn, String text, int x, int y, int color) {
        fontRendererIn.drawStringWithShadow(text, x, y, 0x3FFFFFFF);
    }
        
     
    @Redirect(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiMainMenu;splashText(IIIIII)V"))
        public void splashText(GuiMainMenu guiMainMenu, FontRenderer fontRendererIn, String text, int x, int y, int color) {
            fontRendererIn.drawStringWithShadow(text, x, y, 0x3FFFFFFF);
            
            
            
    }
    @Redirect(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiMainMenu;splashText(IIIIII)V"))
    public void ChangeSplashText(GuiMainMenu gui, FontRenderer fontRendererIn, int width, int height, String splashText) {
        fontRendererIn.drawStringWithShadow(splashText, 500, 500, 500);
    }
    @Inject(method = "drawScreen", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/TextureManager;bindTexture(Lnet/minecraft/util/ResourceLocation;)V"))
    public void changejavaversion(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
    	
    }

}
