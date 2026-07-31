package divinerpg.attachments.data.base;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import divinerpg.registries.DivineRegistries;
import net.minecraft.world.entity.Entity;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Objects;
import java.util.function.Supplier;

public abstract class ModAttachment<T> {
    public final DeferredHolder<AttachmentType<?>, AttachmentType<T>> attachment;

    public ModAttachment(DeferredHolder<AttachmentType<?>, AttachmentType<T>> attachment) {
        this.attachment = attachment;
    }

    public ModAttachment(String name, Supplier<T> defaultValue, MapCodec<T> codec) {
        this.attachment = DivineRegistries.ATTACHMENTS.register(
                name,
                () -> AttachmentType.builder(defaultValue).serialize(codec).build()
        );
    }

    public ModAttachment(String name, Supplier<T> defaultValue, Codec<T> codec) {
        this(name, defaultValue, codec.fieldOf("value"));
    }

    public abstract void update(Entity e, T data);

    public boolean validate(Entity e, T data) {
        return !Objects.equals(e.getData(this.attachment.get()), data);
    }

    public void set(Entity e, T data) {
        if (validate(e, data)) {
            e.setData(this.attachment.get(), data);
            update(e, data);
        }
    }

    public void setSilent(Entity e, T data) {
        if (validate(e, data)) {
            e.setData(this.attachment.get(), data);
        }
    }

    public T get(Entity e) {
        return e.getData(this.attachment.get());
    }

    public T getOrDefault(Entity e, T defaultValue) {
        return e.hasData(this.attachment.get()) ? e.getData(this.attachment.get()) : defaultValue;
    }

    public boolean has(Entity e) {
        return e.hasData(this.attachment.get());
    }

    public void clone(Entity original, Entity clone) {
        if (original.hasData(this.attachment.get())) {
            set(clone, original.getData(this.attachment.get()));
        }
    }
}