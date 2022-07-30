package me.ionar.salhack.mixin.client;

import me.ionar.salhack.gui.chest.SalGuiChest;
import me.ionar.salhack.gui.entity.SalGuiDupeButton;
import me.ionar.salhack.managers.ModuleManager;
import me.ionar.salhack.module.misc.ChestStealerModule;
import me.ionar.salhack.module.misc.ManualDupeModule;
import me.ionar.salhack.module.ui.ChestModule;
import me.ionar.salhack.module.ui.DupeModule;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

//Shout-out and a half to Kami-Blue for this code: https://github.com/kami-blue
@Mixin(GuiContainer.class)
public abstract class MixinGuiContainer extends GuiScreen {

    private SalGuiChest salGuiChest;
    private final ChestStealerModule ChestStealer = (ChestStealerModule) ModuleManager.Get().GetMod(ChestStealerModule.class);
    private final ChestModule chestModule = (ChestModule) ModuleManager.Get().GetMod(ChestModule.class);

    private SalGuiDupeButton salGuiDupeButton;
    private final DupeModule dupeModule = (DupeModule) ModuleManager.Get().GetMod(DupeModule.class);
    private final ManualDupeModule manualDupeModule = (ManualDupeModule) ModuleManager.Get().GetMod(ManualDupeModule.class);

    @Shadow protected int guiLeft;
    @Shadow protected int guiTop;


    @Inject(method = "initGui", at = @At("RETURN"))
    public void initGui(CallbackInfo info)
    {
        /// Clear old ones :)
        buttonList.clear();

        salGuiChest = new SalGuiChest(1337, this.width / 2 - 75, this.guiTop - 20, "Steal");
        salGuiDupeButton = new SalGuiDupeButton(1338, this.width / 2 - 50, this.guiTop - 20, "Dupe");
        this.buttonList.add(salGuiDupeButton);
        this.buttonList.add(salGuiChest);
        salGuiDupeButton.setWidth(100);
        salGuiChest.setWidth(150);
        updateButton();

    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 1337) {
            ChestStealer.toggle();
        } else if(button.id == 1338) {
            manualDupeModule.toggle();
        } else {
            super.actionPerformed(button);
        }

    }

    @Inject(method = "updateScreen", at = @At("HEAD"))
    public void updateScreen(CallbackInfo ci) {
        updateButton();
    }

    private void updateButton() {
        if(chestModule.isEnabled() && chestModule.validGui) {
            salGuiChest.visible = true;
            if (ChestStealer.isEnabled())
                salGuiChest.displayString = "Stop";
            else if (!ChestStealer.isEnabled())
                salGuiChest.displayString = ChestStealer.Mode.getValue().toString();
        } else {
            salGuiChest.visible = false;
        }

        if(dupeModule.isEnabled() && dupeModule.validGui) {
            salGuiDupeButton.visible = true;
            salGuiDupeButton.displayString = "Dupe";
        } else {
            salGuiDupeButton.visible = false;
        }
    }

}
