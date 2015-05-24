/*******************************************************************************
 * Copyright 2015, the Biomes O' Plenty Team
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * 
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package biomesoplenty.common.biome.overworld;

import java.util.Random;

import biomesoplenty.api.biome.BOPBiome;
import biomesoplenty.api.biome.generation.GeneratorStage;
import biomesoplenty.api.biome.generation.GeneratorWeighted;
import biomesoplenty.api.block.BOPBlocks;
import biomesoplenty.common.block.BlockBOPPlant;
import biomesoplenty.common.block.BlockGem;
import biomesoplenty.common.enums.BOPGems;
import biomesoplenty.common.enums.BOPPlants;
import biomesoplenty.common.util.config.ConfigHelper;
import biomesoplenty.common.world.feature.GeneratorFlora;
import biomesoplenty.common.world.feature.GeneratorGrass;
import biomesoplenty.common.world.feature.GeneratorOreSingle;
import biomesoplenty.common.world.feature.tree.GeneratorBigTree;
import biomesoplenty.common.world.feature.tree.GeneratorBush;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraftforge.common.BiomeManager.BiomeType;

public class BiomeGenDenseForest extends BOPBiome
{
    private static final Height biomeHeight = new Height(0.075F, 0.05F);
    
    public IBlockState usualTopBlock;
    public IBlockState alternateTopBlock;
    
    public BiomeGenDenseForest()
    {
        this.setHeight(biomeHeight);
        this.setColor(8246897);
        this.setTemperatureRainfall(0.7F, 0.7F);
        
        this.addWeight(BiomeType.WARM, 7);
        
        this.topBlock = Blocks.grass.getDefaultState();
        this.fillerBlock = Blocks.dirt.getDefaultState();
        this.usualTopBlock = this.topBlock;
        this.alternateTopBlock = Blocks.dirt.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
        
        this.addGenerator("bushes", GeneratorStage.FLOWERS, new GeneratorFlora(1, BlockBOPPlant.paging.getVariantState(BOPPlants.BUSH)));
        this.addGenerator("berry_bushes", GeneratorStage.FLOWERS, new GeneratorFlora(1, BlockBOPPlant.paging.getVariantState(BOPPlants.BERRYBUSH)));
        this.addGenerator("shrubs", GeneratorStage.FLOWERS, new GeneratorFlora(1, BlockBOPPlant.paging.getVariantState(BOPPlants.SHRUB)));
        this.addGenerator("water_reeds", GeneratorStage.LILYPAD, new GeneratorFlora(2, BlockBOPPlant.paging.getVariantState(BOPPlants.REED), 128));
        
        this.addGenerator("leaf_piles", GeneratorStage.FLOWERS, new GeneratorFlora(15, BlockBOPPlant.paging.getVariantState(BOPPlants.LEAFPILE), 256));
        
        this.addGenerator("huge_trees", GeneratorStage.TREE, new GeneratorBigTree(10, false, 15, 25, Blocks.log.getDefaultState(), Blocks.leaves.getDefaultState()));
        this.addGenerator("leaves_clusters", GeneratorStage.POST, new GeneratorBush(7, Blocks.log.getDefaultState(), Blocks.leaves.getDefaultState()));
        
        GeneratorWeighted grassGenerator = new GeneratorWeighted(10);
        grassGenerator.add(1, new GeneratorGrass(1, BlockBOPPlant.paging.getVariantState(BOPPlants.WHEATGRASS)));
        grassGenerator.add(1, new GeneratorGrass(1, BlockBOPPlant.paging.getVariantState(BOPPlants.DAMPGRASS)));
        grassGenerator.add(1, new GeneratorGrass(1, Blocks.tallgrass.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.FERN)));
        grassGenerator.add(2, new GeneratorGrass(1, Blocks.tallgrass.getDefaultState().withProperty(BlockTallGrass.TYPE, BlockTallGrass.EnumType.GRASS)));
        this.addGenerator("grass", GeneratorStage.GRASS, grassGenerator);
        
        this.addGenerator("amber", GeneratorStage.SAND, new GeneratorOreSingle(BOPBlocks.gem_ore.getDefaultState().withProperty(BlockGem.VARIANT, BOPGems.AMBER), 12, 4, 32));
    }

    @Override
    public void configure(ConfigHelper conf)
    {
        super.configure(conf);
        
        this.usualTopBlock = this.topBlock;
        this.alternateTopBlock = conf.getBlockState("alternateTopBlock", this.alternateTopBlock);
    }
    
    @Override
    public void genTerrainBlocks(World world, Random random, ChunkPrimer primer, int x, int z, double noise)
    {
        this.topBlock = (noise > 1.75D) ? this.alternateTopBlock : this.usualTopBlock;
        this.generateBiomeTerrain(world, random, primer, x, z, noise);
    }
    
    @Override
    public int getGrassColorAtPos(BlockPos pos)
    {
        return 8246897;
    }

    @Override
    public int getFoliageColorAtPos(BlockPos pos)
    {
        return 10022742;
    }
}