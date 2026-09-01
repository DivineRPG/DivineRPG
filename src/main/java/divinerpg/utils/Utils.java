package divinerpg.utils;

import com.google.gson.Gson;
import divinerpg.DivineRPG;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Utils {

    public static volatile byte ICEIKA_WEATHER = (byte)(Math.random() * 4);//0 = snow, 1 = hail, 2 = blizzard, 3 = fog
    private static final Set<UUID> DEV_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> TESTER_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> SPECIAL_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> ARTIST_LIST = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> FRIEND_LIST = ConcurrentHashMap.newKeySet();

    public static boolean isDeveloperName(UUID name) {return DEV_LIST.contains(name);}
    public static boolean isTesterName(UUID name) {return TESTER_LIST.contains(name);}
    public static boolean isSpecial(UUID name) {return SPECIAL_LIST.contains(name);}
    public static boolean isArtist(UUID name) {return ARTIST_LIST.contains(name);}
    public static boolean isFriend(UUID name) {return FRIEND_LIST.contains(name);}

    public static String translate(String langTo, String text) {
        try {
            String urlStr = "https://translate.googleapis.com/translate_a/single?client=gtx&sl=en&tl=" + langTo + "&dt=t&q=" + URLEncoder.encode(text, StandardCharsets.UTF_8);
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) response.append(inputLine);
            in.close();
            String result = response.toString();
            return result.substring(4, result.indexOf("\"", 4));
        } catch (Exception e) {
            return text;
        }
    }

    public static void loadHatInformation() {
        HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5)).build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://raw.githubusercontent.com/DivineRPG/DivineRPG-Assets/main/hats.json"))
                .GET()
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    if (response.statusCode() == 200) {
                        parseHats(response.body());
                    }
                })
                .exceptionally(ex -> {
                    ex.printStackTrace();
                    return null;
                });
    }
    public static class HatsInfo {
        public List<UUID> dev;
        public List<UUID> tester;
        public List<UUID> special;
        public List<UUID> artists;
        public List<UUID> friend;
    }

    private static void parseHats(String json) {
        try {
            HatsInfo info = new Gson().fromJson(json, HatsInfo.class);
            if (info != null) {
                DEV_LIST.clear();
                DEV_LIST.addAll(info.dev);
                TESTER_LIST.clear();
                TESTER_LIST.addAll(info.tester);
                SPECIAL_LIST.clear();
                SPECIAL_LIST.addAll(info.special);
                ARTIST_LIST.clear();
                ARTIST_LIST.addAll(info.artists);
                FRIEND_LIST.clear();
                FRIEND_LIST.addAll(info.friend);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ModelLayerLocation createLocation(String name) {return new ModelLayerLocation(Identifier.fromNamespaceAndPath(DivineRPG.MODID, name), "main");}

    public static final ModelLayerLocation
            layerHumanoid = createLocation("humanoid"),
            layerBat = createLocation("bat"),
            layerSpider = createLocation("spider"),
            layerMinecart = createLocation("minecart");

    public static float rotlerp(float rot, float g, float bound) {
        float f = Mth.wrapDegrees(g - rot);
        if(f > bound) f = bound;
        if(f < -bound) f = -bound;
        float f1 = rot + f;
        if(f1 < 0F) f1 += 360F;
        else if(f1 > 360F) f1 -= 360F;
        return f1;
    }
    public static void awardAdvancement(MinecraftServer server, ServerPlayer player, Identifier advancement, String criterion) {
        var adv = server.getAdvancements().get(advancement);
        if(adv != null) {
            var progress = player.getAdvancements().getOrStartProgress(adv);
            if(!progress.isDone()) progress.getRemainingCriteria().forEach((c) -> {
                if(c.equals(criterion)) player.getAdvancements().award(adv, c);
            });
        }
    }
    public static Block getBlock(String registryName) {
        return BuiltInRegistries.BLOCK.get(Identifier.fromNamespaceAndPath(DivineRPG.MODID, registryName)).get().value();
    }
    public static BlockState getBlockState(String registryName) {
        return BuiltInRegistries.BLOCK.get(Identifier.fromNamespaceAndPath(DivineRPG.MODID, registryName)).get().value().defaultBlockState();
    }

    public static void drop(Level level, Vec3 pos, @Nullable ItemStack item) {
        if(item != null) level.addFreshEntity(new ItemEntity(level, pos.x, pos.y, pos.z, item));
    }

    public static boolean hasEnchantment(ResourceKey<Enchantment> enchantment, ItemStack stack) {
        ItemEnchantments itemEnchantmentsComponent = stack.getOrDefault(DataComponents.ENCHANTMENTS, ItemEnchantments.EMPTY);
        for(Object2IntMap.Entry<Holder<Enchantment>> entry : itemEnchantmentsComponent.entrySet()) if(entry.getKey().is(enchantment)) return true;
        return false;
    }

    public static Direction.Axis checkForFrame(Level level, BlockPos pos, RuleTest frame) {
        Direction d = null;
        for(Direction di : Direction.values()) if(frame.test(level.getBlockState(pos.relative(di)), level.getRandom())) {
            d = di;
            break;
        } if(d == null) return null;
        return travel(level, pos, Direction.Axis.X, frame) ? Direction.Axis.X : (travel(level, pos, Direction.Axis.Z, frame) ? Direction.Axis.Z : null);
    }
    protected static boolean travel(Level level, BlockPos pos, Direction.Axis axis, RuleTest frame) {
        Direction d = lookForFrameBlock(level, pos, axis, frame), dir = d;
        if(d == null) return false;
        BlockState state;
        BlockPos.MutableBlockPos mut = pos.mutable();
        while((dir = dir.getClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X)) != d) {
            state = level.getBlockState(mut.relative(dir));
            if(frame.test(state, level.getRandom())) continue;
            if(state.isAir()) break;
            return false;
        } if(dir == d) return true;
        mut.move(d = dir);
        while(mut.distManhattan(pos) < 33 && !mut.equals(pos)) {
            if(!frame.test(level.getBlockState(mut.relative(d.getCounterClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X))), level.getRandom())) return false;
            do {
                state = level.getBlockState(mut.relative(dir));
                if(frame.test(state, level.getRandom())) continue;
                if(state.isAir()) {
                    d = dir;
                    break;
                } return false;
            } while((dir = dir.getClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X)) != d);
            mut.move(d);
        } return frame.test(level.getBlockState(mut.relative(d.getCounterClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X))), level.getRandom()) && mut.equals(pos);
    }
    protected static Direction lookForFrameBlock(Level level, BlockPos pos, Direction.Axis axis, RuleTest frame) {
        Direction d = axis == Direction.Axis.X ? Direction.EAST : Direction.SOUTH, dir = d;
        do {
            if(frame.test(level.getBlockState(pos.relative(dir)), level.getRandom())) return dir;
        } while((dir = dir.getClockWise(axis == Direction.Axis.X ? Direction.Axis.Z : Direction.Axis.X)) != d);
        return null;
    }
    public static void spreadBlock(Level level, BlockState newState, BlockPos pos, Block spreadTarget, Direction.Axis axis) {
        BlockState state;
        if((state = level.getBlockState(pos)).is(spreadTarget) && !state.is(newState.getBlock())) {
            level.setBlock(pos, newState, 16);
            spreadBlock(level, newState, pos.above(), spreadTarget, axis);
            spreadBlock(level, newState, pos.below(), spreadTarget, axis);
            spreadBlock(level, newState, pos.relative(axis, 1), spreadTarget, axis);
            spreadBlock(level, newState, pos.relative(axis, -1), spreadTarget, axis);
        } level.sendBlockUpdated(pos, spreadTarget.defaultBlockState(), newState, 3);
    }

}