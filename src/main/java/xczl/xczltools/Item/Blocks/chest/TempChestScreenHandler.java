package xczl.xczltools.Item.Blocks.chest;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import xczl.xczltools.Item.ModBlock;

public class TempChestScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final int INVENTORY_SIZE =78;

    public TempChestScreenHandler(int syncId, PlayerInventory playerInventory){
        this(syncId, playerInventory,new SimpleInventory(78));
    }
    public TempChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory){
        super(ModBlock.TEMP_CHEST_SCREEN_HANDLER,syncId);

        checkSize(inventory,INVENTORY_SIZE);
        this.inventory = inventory;

        inventory.onOpen(playerInventory.player);

        int i;
        int j;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 13; j++) {
                this.addSlot(new Slot(inventory, i * 13 + j, 12 + j * 18, 18 + i * 18));
            }
        }

        // Player Inventory (27 storage + 9 hotbar)
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 9; j++) {
                this.addSlot(new Slot(playerInventory, i * 9 + j + 9, 48 + j * 18, 140 + i * 18));
            }
        }

        for (j = 0; j < 9; j++) {
            this.addSlot(new Slot(playerInventory, j, 48 + j * 18, 198));
        }
    }

    //Shift + 玩家物品栏槽位
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot =this.slots.get(invSlot);
        if(slot!=null && slot.hasStack())
        {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if(invSlot < this.inventory.size()){
                if(!this.insertItem(originalStack,this.inventory.size(),this.slots.size(),true)){
                    return ItemStack.EMPTY;
                }
            }
            else if(!this.insertItem(originalStack,0,this.inventory.size(),false))
            {
                return ItemStack.EMPTY;
            }

            if(originalStack.isEmpty()){
                slot.setStack(ItemStack.EMPTY);
            }
            else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }


}
