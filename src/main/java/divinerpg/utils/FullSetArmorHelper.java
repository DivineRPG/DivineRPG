package divinerpg.utils;

import divinerpg.api.FullArmorHandler;
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
                && legs == ModItems.bedrockLegs
                && body == ModItems.bedrockBody
                && helmet == ModItems.bedrockHelmet);
    }

    public boolean isInfernal(){
        return boots == ModItems.infernoBoots
                && legs == ModItems.infernoLegs
                && body == ModItems.infernoBody
                && helmet == ModItems.infernoHelmet;
    }

    public boolean isNetherite(){
        return boots == ModItems.netheriteBoots
                && legs == ModItems.netheriteLegs
                && body == ModItems.netheriteBody
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
                && body == ModItems.vemosBody
                && legs == ModItems.vemosLegs
                && helmet == ModItems.vemosHelmet;
    }

    public boolean isKorma(){
        return boots == ModItems.kormaBoots
                && body == ModItems.kormaBody
                && legs == ModItems.kormaLegs
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
                && body == ModItems.eliteRealmiteBody
                && legs == ModItems.eliteRealmiteLegs
                && helmet == ModItems.eliteRealmiteHelmet;
    }

    public boolean isAquastrive(){
        return boots == ModItems.aquastriveBoots
                && body == ModItems.aquastriveBody
                && legs == ModItems.aquastriveLegs
                && helmet == ModItems.aquastriveHelmet;
    }

    public boolean isShadow(){
        return boots == ModItems.shadowBoots
                && body == ModItems.shadowBody
                && legs == ModItems.shadowLegs
                && helmet == ModItems.shadowHelmet;
    }

    public boolean isFrozen(){
        return boots == ModItems.frozenBoots
                && body == ModItems.frozenBody
                && legs == ModItems.frozenLegs
                && helmet == ModItems.frozenHelmet;
    }

    public boolean isTerran(){
        return boots == ModItems.terranBoots
                && body == ModItems.terranBody
                && legs == ModItems.terranLegs
                && helmet == ModItems.terranHelmet;
    }

    public boolean isSkeleman(){
        return boots == ModItems.skelemanBoots
                && body == ModItems.skelemanBody
                && legs == ModItems.skelemanLegs
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
//        return body == ModItems.glisteningBody
//                && legs == ModItems.glisteningLegs
//                && boots == ModItems.glisteningBoots
//                && helmet == specialHelmet;
//    }
//
//    public boolean isDemonised(Item specialHelmet){
//        if (specialHelmet == null)
//            specialHelmet = ModItems.demonizedHelmet;
//
//        return body == ModItems.demonizedBody
//                && legs == ModItems.demonizedLegs
//                && boots == ModItems.demonizedBoots
//                && helmet == specialHelmet;
//    }
//
//    public boolean isTormented(Item specialHelmet){
//        if (specialHelmet == null)
//            specialHelmet = ModItems.tormentedHelmet;
//
//        return body == ModItems.tormentedBody
//                && legs == ModItems.tormentedLegs
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
                (legs == ModItems.enderLegs
                        || legs == ModItems.redEnderLegs
                        || legs == ModItems.yellowEnderLegs
                        || legs == ModItems.greenEnderLegs
                        || legs == ModItems.blueEnderLegs
                        || legs == ModItems.grayEnderLegs)
                &&
                (body == ModItems.enderBody
                        || body == ModItems.redEnderBody
                        || body == ModItems.yellowEnderBody
                        || body == ModItems.greenEnderBody
                        || body == ModItems.blueEnderBody
                        || body == ModItems.grayEnderBody)
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
                && legs == ModItems.arlemiteLegs
                && body == ModItems.arlemiteBody
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
                (legs == ModItems.rupeeLegs
                        || legs == ModItems.redRupeeLegs
                        || legs == ModItems.yellowRupeeLegs
                        || legs == ModItems.greenRupeeLegs
                        || legs == ModItems.blueRupeeLegs
                        || legs == ModItems.grayRupeeLegs)
                &&
                (body == ModItems.rupeeBody
                        || body == ModItems.redRupeeBody
                        || body == ModItems.yellowRupeeBody
                        || body == ModItems.greenRupeeBody
                        || body == ModItems.blueRupeeBody
                        || body == ModItems.grayRupeeBody)
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
        return body == ModItems.corruptedBody
                && legs == ModItems.corruptedLegs
                && boots == ModItems.corruptedBoots
                && helmet == ModItems.corruptedHelmet;
    }

    public boolean isKraken(){
        return boots == ModItems.krakenBoots
                && body == ModItems.krakenBody
                && legs == ModItems.krakenLegs
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
                && legs == ModItems.witherReaperLegs
                && body == ModItems.witherReaperBody
                && helmet == ModItems.witherReaperHelmet;
    }

    public boolean isJungle(){
        return boots == ModItems.jungleBoots
                && legs == ModItems.jungleLegs
                && body == ModItems.jungleBody
                && helmet == ModItems.jungleHelmet;
    }

    public boolean isJackoMan(){
        return boots == ModItems.jackOManBoots
                && legs == ModItems.jackOManLegs
                && body == ModItems.jackOManBody
                && helmet == ModItems.jackOManHelmet;
    }
}
