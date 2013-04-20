package com.konals.hammermod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.konals.hammermod.tileentity.ContainerBloomery;
import com.konals.hammermod.tileentity.TileEntityBloomeryCore;

public class GuiBloomery extends GuiContainer {

    private TileEntityBloomeryCore tileEntity;

    public GuiBloomery(InventoryPlayer playerInventory, TileEntityBloomeryCore tileEntity) {

        super(new ContainerBloomery(playerInventory, tileEntity));

        this.tileEntity = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {

        final String invTitle = "Multi-Furnace";
        fontRenderer.drawString(invTitle, xSize / 2 - fontRenderer.getStringWidth(invTitle) / 2, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {

        GL11.glColor4f(1f, 1f, 1f, 1f);

        mc.renderEngine.bindTexture("/gui/furnace.png");

        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        int i1;

        if (tileEntity.isBurning()) {
            i1 = tileEntity.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(x + 56, y + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }

        i1 = tileEntity.getCookProgressScaled(24);
        drawTexturedModalRect(x + 79, y + 34, 176, 14, i1 + 1, 16);
    }
}
