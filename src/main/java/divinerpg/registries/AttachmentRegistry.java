package divinerpg.registries;

import com.mojang.serialization.Codec;

import divinerpg.DivineRPG;
import divinerpg.attachments.DimensionalInventory;
import divinerpg.attachments.Reputation;
import divinerpg.config.CommonConfig;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.*;

public class AttachmentRegistry {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, DivineRPG.MODID);
	private AttachmentRegistry() {}
	
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<Integer>> SOUL_TRAP_COUNT = ATTACHMENT_TYPES.register("soul_trap_count", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<Float>> ARCANA = ATTACHMENT_TYPES.register("arcana", () -> AttachmentType.builder(() -> CommonConfig.ARCANA_MAX).serialize(Codec.FLOAT).build());
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<Float>> MAX_ARCANA = ATTACHMENT_TYPES.register("max_arcana", () -> AttachmentType.builder(() -> CommonConfig.ARCANA_MAX).serialize(Codec.FLOAT).build());
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<DimensionalInventory>> DIMENSIONAL_INVENTORY = ATTACHMENT_TYPES.register("dimensional_inventory", () -> AttachmentType.serializable(DimensionalInventory::new).build());
	public static final DeferredHolder<AttachmentType<?>, AttachmentType<Reputation>> REPUTATION = ATTACHMENT_TYPES.register("reputation", () -> AttachmentType.serializable(Reputation::new).build());
//	public static final DeferredHolder<AttachmentType<?>, AttachmentType<Integer>> VARIANT = ATTACHMENT_TYPES.register("variant", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
}