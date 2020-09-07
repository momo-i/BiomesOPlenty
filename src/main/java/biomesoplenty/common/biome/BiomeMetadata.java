/*******************************************************************************
 * Copyright 2020, the Biomes O' Plenty Team
 *
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 *
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/
package biomesoplenty.common.biome;

import biomesoplenty.api.enums.BOPClimates;
import biomesoplenty.common.util.biome.BiomeUtil;
import com.google.common.collect.ImmutableMap;
import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class BiomeMetadata
{
    private final ImmutableMap<BOPClimates, Integer> weightMap;

    @Nullable
    private final RegistryKey<Biome> beachBiome;

    @Nullable
    private final RegistryKey<Biome> riverBiome;

    protected BiomeMetadata(Map<BOPClimates, Integer> weights, @Nullable RegistryKey<Biome> beachBiome, @Nullable RegistryKey<Biome> riverBiome)
    {
        this.weightMap = ImmutableMap.copyOf(weights);
        this.beachBiome = beachBiome;
        this.riverBiome = riverBiome;
    }

    public Map<BOPClimates, Integer> getWeightMap()
    {
        return this.weightMap;
    }

    @Nullable
    public RegistryKey<Biome> getBeachBiome()
    {
        return this.beachBiome;
    }

    @Nullable
    public RegistryKey<Biome> getRiverBiome()
    {
        return this.riverBiome;
    }

    public boolean hasWeights()
    {
        return !this.weightMap.isEmpty() && !this.weightMap.entrySet().stream().allMatch((entry) -> entry.getValue().equals(0));
    }
}
