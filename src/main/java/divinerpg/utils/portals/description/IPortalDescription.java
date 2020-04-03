package divinerpg.utils.portals.description;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Describes base portal functionality
 */
public interface IPortalDescription {
    /**
     * Frame of portal
     *
     * @return
     */
    Block getFrame();

    /**
     * Gets portal block
     *
     * @return
     */
    Block getPortal();

    /**
     * Creates portal in current position
     *
     * @param world - world where we are creating portal
     * @param pos   - position where to create portal
     * @return matched portal description
     */
    BlockPattern.PatternHelper createPortal(World world, BlockPos pos);

    /**
     * lights the portal frame
     *
     * @param world      - world where frame exist
     * @param frameMatch - frame match (from matchFrame() method)
     */
    void lightPortal(World world, BlockPattern.PatternHelper frameMatch);

    /**
     * Detects if on that cords is worked portal
     *
     * @param world - world where detecting portals
     * @param pos   - any portal block position
     * @return - portal match description
     */
    @Nullable
    BlockPattern.PatternHelper matchWorkingPortal(World world, BlockPos pos);

    /**
     * Detects if there a frame ready to ignite
     *
     * @param world - world where perform searching
     * @param pos   - any portal frame position
     * @return - portal frame match
     */
    @Nullable
    BlockPattern.PatternHelper matchFrame(World world, BlockPos pos);

    /**
     * Gets player position from portal match
     *
     * @param world     - world where portal existed
     * @param fullMatch - portal match description (from createPortal() or matchWorkingPortal() methods)
     * @return
     */
    BlockPos getPlayerPortalPosition(World world, BlockPattern.PatternHelper fullMatch);
}
