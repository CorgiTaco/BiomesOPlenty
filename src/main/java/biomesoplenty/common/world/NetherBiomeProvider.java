/*******************************************************************************
 * Copyright 2014-2019, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.world;

import com.google.common.collect.Sets;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.storage.WorldInfo;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class NetherBiomeProvider extends OverworldBiomeProvider
{
    private final Layer genBiomes;

    public NetherBiomeProvider(OverworldBiomeProviderSettings settingsProvider)
    {
        super(settingsProvider);

        this.topBlocksCache.add(Blocks.NETHERRACK.getDefaultState());
        this.genBiomes = BOPLayerUtil.createGenLayers(settingsProvider.getSeed(), settingsProvider.getGeneratorType(), settingsProvider.getGeneratorSettings())[0];
    }

    @Override
    public Biome getNoiseBiome(int x, int y, int z)
    {
        return this.genBiomes.get(x, z);
    }
}