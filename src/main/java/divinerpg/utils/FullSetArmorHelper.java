package divinerpg.utils;

import divinerpg.api.java.divinerpg.api.armorset.FullArmorHandler;
import divinerpg.registry.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FullSetArmorHelper {

    private Item boots = null;
    private Item body = null;
    private Item legs = null;
    private Item helmet = null;

    public FullSetArmorHelper(EntityPlayer player){
        if (player != null
                && player.inventory != null
                && player.inventory.armorInventory != null)
        {
            boots = getItem(player.inventory.armorInventory.get(0));
            legs = getItem(player.inventory.armorInventory.get(1));
            body = getItem(player.inventory.armorInventory.get(2));
            helmet = getItem(player.inventory.armorInventory.get(3));
        }
    }

    public boolean isEquipped(FullArmorHandler handler) {

        return isFullEquipped()
                && handler != null
                && handler.armorVariants.stream().anyMatch(armorSetVariant -> armorSetVariant.isEquipped(helmet, body, legs, boots));
    }

    private Item getItem(ItemStack stack){
        if (stack != null){
            return stack.getItem();
        }

        return null;
    }

    public boolean isFullEquipped(){
        return body != null
                && boots != null
                && legs != null
                && helmet != null;
    }


    public Item getBody() {
        return body;
    }

    public Item getBoots() {
        return boots;
    }

    public Item getHelmet() {
        return helmet;
    }

    public Item getLegs() {
        return legs;
    }


    public boolean isBedrock(){
        return (boots == ModItems.bedrockBoots
                && legs == ModItems.bedrockLeggings
                && body == ModItems.bedrockChestplate
                && helmet == ModItems.bedrockHelmet);
    }

    public boolean isInfernal(){
        return boots == ModItems.infernoBoots
                && legs == ModItems.infernoLeggings
                && body == ModItems.infernoChestplate
                && helmet == ModItems.infernoHelmet;
    }

    public boolean isNetherite(){
        return boots == ModItems.netheriteBoots
                && legs == ModItems.netheriteLeggings
                && body == ModItems.netheriteChestplate
                && helmet == ModItems.netheriteHelmet;
    }

    public boolean isSkythern(){
        return boots == ModItems.skythernBoots
                && body == ModItems.skythernChestplate
                && legs == ModItems.skythernLeggings
                && helmet == ModItems.skythernHelmet;
    }

    public boolean isMortum(){
        return boots == ModItems.mortumBoots
                && body == ModItems.mortumChestplate
                && legs == ModItems.mortumLeggings
                && helmet == ModItems.mortumHelmet;
    }

    public boolean isVemos(){
        return boots == ModItems.vemosBoots
                && body == ModItems.vemosChestplate
                && legs == ModItems.vemosLeggings
                && helmet == ModItems.vemosHelmet;
    }

    public boolean isKorma(){
        return boots == ModItems.kormaBoots
                && body == ModItems.kormaChestplate
                && legs == ModItems.kormaLeggings
                && helmet == ModItems.kormaHelmet;
    }

    public boolean isWildwood(){
        return boots == ModItems.wildwoodBoots
                && body == ModItems.wildwoodChestplate
                && legs == ModItems.wildwoodLeggings
                && helmet == ModItems.wildwoodHelmet;
    }

    public boolean isEliteRealmite(){
        return boots == ModItems.eliteRealmiteBoots
                && body == ModItems.eliteRealmiteChestplate
                && legs == ModItems.eliteRealmiteLeggings
                && helmet == ModItems.eliteRealmiteHelmet;
    }

    public boolean isAquastrive(){
        return boots == ModItems.aquastriveBoots
                && body == ModItems.aquastriveChestplate
                && legs == ModItems.aquastriveLeggings
                && helmet == ModItems.aquastriveHelmet;
    }

    public boolean isShadow(){
        return boots == ModItems.shadowBoots
                && body == ModItems.shadowChestplate
                && legs == ModItems.shadowLeggings
                && helmet == ModItems.shadowHelmet;
    }

    public boolean isFrozen(){
        return boots == ModItems.frozenBoots
                && body == ModItems.frozenChestplate
                && legs == ModItems.frozenLeggings
                && helmet == ModItems.frozenHelmet;
    }

    public boolean isTerran(){
        return boots == ModItems.terranBoots
                && body == ModItems.terranChestplate
                && legs == ModItems.terranLeggings
                && helmet == ModItems.terranHelmet;
    }

    public boolean isSkeleman(){
        return boots == ModItems.skelemanBoots
                && body == ModItems.skelemanChestplate
                && legs == ModItems.skelemanLeggings
                && helmet == ModItems.skelemanHelmet;
    }

    public boolean isSanta(){
        return boots == ModItems.santaBoots
                && body == ModItems.santaTunic
                && legs == ModItems.santaPants
                && helmet == ModItems.santaCap;
    }

//    public boolean isGlistening(Item specialHelmet){
//        if (specialHelmet == null)
//            specialHelmet = ModItems.glisteningHelmet;
//
//        return body == ModItems.glisteningChestplate
//                && legs == ModItems.glisteningLeggings
//                && boots == ModItems.glisteningBoots
//                && helmet == specialHelmet;
//    }
//
//    public boolean isDemonised(Item specialHelmet){
//        if (specialHelmet == null)
//            specialHelmet = ModItems.demonizedHelmet;
//
//        return body == ModItems.demonizedChestplate
//                && legs == ModItems.demonizedLeggings
//                && boots == ModItems.demonizedBoots
//                && helmet == specialHelmet;
//    }
//
//    public boolean isTormented(Item specialHelmet){
//        if (specialHelmet == null)
//            specialHelmet = ModItems.tormentedHelmet;
//
//        return body == ModItems.tormentedChestplate
//                && legs == ModItems.tormentedLeggings
//                && boots == ModItems.tormentedBoots
//                && helmet == specialHelmet;
//    }

    public boolean isEnder(){
        return (boots == ModItems.enderBoots
                        || boots == ModItems.redEnderBoots
                        || boots == ModItems.yellowEnderBoots
                        || boots == ModItems.greenEnderBoots
                        || boots == ModItems.blueEnderBoots
                        || boots == ModItems.grayEnderBoots)
                &&
                (legs == ModItems.enderLeggings
                        || legs == ModItems.redEnderLeggings
                        || legs == ModItems.yellowEnderLeggings
                        || legs == ModItems.greenEnderLeggings
                        || legs == ModItems.blueEnderLeggings
                        || legs == ModItems.grayEnderLeggings)
                &&
                (body == ModItems.enderChestplate
                        || body == ModItems.redEnderChestplate
                        || body == ModItems.yellowEnderChestplate
                        || body == ModItems.greenEnderChestplate
                        || body == ModItems.blueEnderChestplate
                        || body == ModItems.grayEnderChestplate)
                &&
                (helmet == ModItems.enderHelmet
                        || helmet == ModItems.redEnderHelmet
                        || helmet == ModItems.yellowEnderHelmet
                        || helmet == ModItems.greenEnderHelmet
                        || helmet == ModItems.blueEnderHelmet
                        || helmet == ModItems.grayEnderHelmet);
    }

    public boolean isArlemit(){
        return boots == ModItems.arlemiteBoots
                && legs == ModItems.arlemiteLeggings
                && body == ModItems.arlemiteChestplate
                && helmet == ModItems.arlemiteHelmet;
    }

    public boolean isRupee(){
        return (boots == ModItems.rupeeBoots
                        || boots == ModItems.redRupeeBoots
                        || boots == ModItems.yellowRupeeBoots
                        || boots == ModItems.greenRupeeBoots
                        || boots == ModItems.blueRupeeBoots
                        || boots == ModItems.grayRupeeBoots)
                &&
                (legs == ModItems.rupeeLeggings
                        || legs == ModItems.redRupeeLeggings
                        || legs == ModItems.yellowRupeeLeggings
                        || legs == ModItems.greenRupeeLeggings
                        || legs == ModItems.blueRupeeLeggings
                        || legs == ModItems.grayRupeeLeggings)
                &&
                (body == ModItems.rupeeChestplate
                        || body == ModItems.redRupeeChestplate
                        || body == ModItems.yellowRupeeChestplate
                        || body == ModItems.greenRupeeChestplate
                        || body == ModItems.blueRupeeChestplate
                        || body == ModItems.grayRupeeChestplate)
                &&
                (helmet == ModItems.rupeeHelmet
                        || helmet == ModItems.redRupeeHelmet
                        || helmet == ModItems.yellowRupeeHelmet
                        || helmet == ModItems.greenRupeeHelmet
                        || helmet == ModItems.blueRupeeHelmet
                        || helmet == ModItems.grayRupeeHelmet);
    }

    public boolean isEden(){
        return boots == ModItems.edenBoots
                && body == ModItems.edenChestplate
                && legs == ModItems.edenLeggings
                && helmet == ModItems.edenHelmet;
    }

    public boolean isHalite(){
        return boots == ModItems.haliteBoots
                && body == ModItems.haliteChestplate
                && legs == ModItems.haliteLeggings
                && helmet == ModItems.haliteHelmet;
    }

    public boolean isCorrupted(){
        return body == ModItems.corruptedChestplate
                && legs == ModItems.corruptedLeggings
                && boots == ModItems.corruptedBoots
                && helmet == ModItems.corruptedHelmet;
    }

    public boolean isKraken(){
        return boots == ModItems.krakenBoots
                && body == ModItems.krakenChestplate
                && legs == ModItems.krakenLeggings
                && helmet == ModItems.krakenHelmet;
    }

    public boolean isUvite(){
       return boots == ModItems.apalachiaBoots
               && legs == ModItems.apalachiaLeggings
               && body == ModItems.apalachiaChestplate
               && helmet == ModItems.apalachiaHelmet;
    }

    public boolean isWither(){
        return boots == ModItems.witherReaperBoots
                && legs == ModItems.witherReaperLeggings
                && body == ModItems.witherReaperChestplate
                && helmet == ModItems.witherReaperHelmet;
    }

    public boolean isJungle(){
        return boots == ModItems.jungleBoots
                && legs == ModItems.jungleLeggings
                && body == ModItems.jungleChestplate
                && helmet == ModItems.jungleHelmet;
    }

    public boolean isJackoMan(){
        return boots == ModItems.jackOManBoots
                && legs == ModItems.jackOManLeggings
                && body == ModItems.jackOManChestplate
                && helmet == ModItems.jackOManHelmet;
    }
}
