/*******************************************************************************
 * Copyright 2021, the Glitchfiend Team.
 * All rights reserved.
 ******************************************************************************/
package biomesoplenty.api.biome;

import biomesoplenty.core.BiomesOPlenty;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import org.apache.commons.compress.utils.Lists;

import java.util.List;

public class BOPBiomes
{
    private static List<ResourceKey<Biome>> bopBiomes = Lists.newArrayList();

    public static final ResourceKey<Biome> BAMBOO_GROVE = register("bamboo_grove");
    public static final ResourceKey<Biome> BAYOU = register("bayou");
    public static final ResourceKey<Biome> BOG = register("bog");
    public static final ResourceKey<Biome> BOREAL_FOREST = register("boreal_forest");
    public static final ResourceKey<Biome> CHERRY_BLOSSOM_GROVE = register("cherry_blossom_grove");
    public static final ResourceKey<Biome> COLD_DESERT = register("cold_desert");
    public static final ResourceKey<Biome> CONIFEROUS_FOREST = register("coniferous_forest");
    public static final ResourceKey<Biome> CRAG = register("crag");
    public static final ResourceKey<Biome> DEAD_FOREST = register("dead_forest");
    public static final ResourceKey<Biome> DENSE_WOODLAND = register("dense_woodland");
    public static final ResourceKey<Biome> DRY_BONEYARD = register("dry_boneyard");
    public static final ResourceKey<Biome> DRYLAND = register("dryland");
    public static final ResourceKey<Biome> DUNE_BEACH = register("dune_beach");
    public static final ResourceKey<Biome> FIELD = register("field");
    public static final ResourceKey<Biome> FIR_CLEARING = register("fir_clearing");
    public static final ResourceKey<Biome> FLOODPLAIN = register("floodplain");
    public static final ResourceKey<Biome> FORESTED_FIELD = register("forested_field");
    public static final ResourceKey<Biome> FUNGAL_JUNGLE = register("fungal_jungle");
    public static final ResourceKey<Biome> GRASSLAND = register("grassland");
    public static final ResourceKey<Biome> HIGHLAND = register("highland");
    public static final ResourceKey<Biome> HIGHLAND_MOOR = register("highland_moor");
    public static final ResourceKey<Biome> JADE_CLIFFS = register("jade_cliffs");
    public static final ResourceKey<Biome> LAVENDER_FIELD = register("lavender_field");
    public static final ResourceKey<Biome> LAVENDER_FOREST = register("lavender_forest");
    public static final ResourceKey<Biome> LUSH_DESERT = register("lush_desert");
    public static final ResourceKey<Biome> LUSH_SAVANNA = register("lush_savanna");
    public static final ResourceKey<Biome> MAPLE_FOREST = register("maple_forest");
    public static final ResourceKey<Biome> MARSH = register("marsh");
    public static final ResourceKey<Biome> MEDITERRANEAN_FOREST = register("mediterranean_forest");
    public static final ResourceKey<Biome> MEDITERRANEAN_LAKES = register("mediterranean_lakes");
    public static final ResourceKey<Biome> MUSKEG = register("muskeg");
    public static final ResourceKey<Biome> MYSTIC_GROVE = register("mystic_grove");
    public static final ResourceKey<Biome> OLD_GROWTH_DEAD_FOREST = register("old_growth_dead_forest");
    public static final ResourceKey<Biome> OMINOUS_WOODS = register("ominous_woods");
    public static final ResourceKey<Biome> ORCHARD = register("orchard");
    public static final ResourceKey<Biome> ORIGIN_VALLEY = register("origin_valley");
    public static final ResourceKey<Biome> PASTURE = register("pasture");
    public static final ResourceKey<Biome> PRAIRIE = register("prairie");
    public static final ResourceKey<Biome> PUMPKIN_PATCH = register("pumpkin_patch");
    public static final ResourceKey<Biome> RAINBOW_HILLS = register("rainbow_hills");
    public static final ResourceKey<Biome> RAINFOREST = register("rainforest");
    public static final ResourceKey<Biome> RAINFOREST_CLIFFS = register("rainforest_cliffs");
    public static final ResourceKey<Biome> REDWOOD_FOREST = register("redwood_forest");
    public static final ResourceKey<Biome> ROCKY_SHRUBLAND = register("rocky_shrubland");
    public static final ResourceKey<Biome> SCRUBLAND = register("scrubland");
    public static final ResourceKey<Biome> SHRUBLAND = register("shrubland");
    public static final ResourceKey<Biome> SEASONAL_FOREST = register("seasonal_forest");
    public static final ResourceKey<Biome> SNOWY_CONIFEROUS_FOREST = register("snowy_coniferous_forest");
    public static final ResourceKey<Biome> SNOWY_FIR_CLEARING = register("snowy_fir_clearing");
    public static final ResourceKey<Biome> SNOWY_MAPLE_FOREST = register("snowy_maple_forest");
    public static final ResourceKey<Biome> TROPICS = register("tropics");
    public static final ResourceKey<Biome> TUNDRA = register("tundra");
    public static final ResourceKey<Biome> VOLCANO = register("volcano");
    public static final ResourceKey<Biome> VOLCANIC_PLAINS = register("volcanic_plains");
    public static final ResourceKey<Biome> WASTELAND = register("wasteland");
    public static final ResourceKey<Biome> WETLAND = register("wetland");
    public static final ResourceKey<Biome> WOODED_SCRUBLAND = register("wooded_scrubland");
    public static final ResourceKey<Biome> WOODLAND = register("woodland");

    public static List<ResourceKey<Biome>> getBOPBiomes()
    {
        return ImmutableList.copyOf(bopBiomes);
    }

    private static ResourceKey<Biome> register(String name)
    {
        ResourceKey<Biome> key = ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(BiomesOPlenty.MOD_ID, name));;
        bopBiomes.add(key);
        return key;
    }
}
