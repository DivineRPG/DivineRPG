package divinerpg.capability;

import java.util.ArrayList;

import divinerpg.entities.base.FactionEntity.Faction;
import net.minecraft.nbt.CompoundTag;

public class Reputation {
	ArrayList<Faction> factions = new ArrayList<>();
	ArrayList<Integer> reputation = new ArrayList<>();
	public void transferTo(Reputation target) {
		target.factions = factions;
		target.reputation = reputation;
	}
	public void resetReputation(Faction faction) {
		int i = factions.indexOf(faction);
		if(i > -1) reputation.set(i, faction.startingReputation);
	}
	public void setReputation(Faction faction, int reputation) {
		int i = factions.indexOf(faction);
		if(i > -1) this.reputation.set(i, reputation);
		else {
			factions.add(faction);
			this.reputation.add(reputation);
		}
	}
	public void modifyReputation(Faction faction, int reputation) {
		int i = factions.indexOf(faction);
		if(i > -1) this.reputation.set(i, this.reputation.get(i) + reputation);
		else {
			factions.add(faction);
			this.reputation.add(faction.startingReputation + reputation);
		}
	}
	public int getReputation(Faction faction) {
		int i = factions.indexOf(faction);
		if(i > -1) return reputation.get(i);
		return faction.startingReputation;
	}
	public CompoundTag saveTo(CompoundTag tag) {
		for(int i = 0; i < factions.size(); i++) tag.putInt(factions.get(i).reputationIdentifier, reputation.get(i));
		return tag;
	}
	public void loadFrom(CompoundTag tag) {
		if(tag.contains(Faction.GROGLIN.reputationIdentifier)) setReputation(Faction.GROGLIN, tag.getInt(Faction.GROGLIN.reputationIdentifier));
		if(tag.contains(Faction.GRUZZORLUG.reputationIdentifier)) setReputation(Faction.GRUZZORLUG, tag.getInt(Faction.GRUZZORLUG.reputationIdentifier));
		if(tag.contains(Faction.ICEIKA_MERCHANT.reputationIdentifier)) setReputation(Faction.ICEIKA_MERCHANT, tag.getInt(Faction.ICEIKA_MERCHANT.reputationIdentifier));
	}
}