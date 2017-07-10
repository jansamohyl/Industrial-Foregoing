package com.buuz135.industrial.proxy;

import com.buuz135.industrial.fluid.IFCustomFluidBlock;
import com.buuz135.industrial.tile.block.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockRegistry {

    public static PetrifiedFuelGeneratorBlock petrifiedFuelGeneratorBlock;
    public static EnchantmentRefinerBlock enchantmentRefinerBlock;
    public static EnchantmentExtractorBlock enchantmentExtractorBlock;
    public static EnchantmentAplicatorBlock enchantmentAplicatorBlock;
    public static MobRelocatorBlock mobRelocatorBlock;
    public static PotionEnervatorBlock potionEnervatorBlock;
    public static AnimalIndependenceSelectorBlock animalIndependenceSelectorBlock;
    public static AnimalStockIncreaserBlock animalStockIncreaserBlock;
    public static CropSowerBlock cropSowerBlock;
    public static CropEnrichMaterialInjectorBlock cropEnrichMaterialInjectorBlock;
    public static CropRecolectorBlock cropRecolectorBlock;
    public static BlackHoleUnitBlock blackHoleUnitBlock;
    public static WaterCondensatorBlock waterCondensatorBlock;
    public static WaterResourcesCollectorBlock waterResourcesCollectorBlock;
    public static AnimalResourceHarvesterBlock animalResourceHarvesterBlock;
    public static MobSlaughterFactoryBlock mobSlaughterFactoryBlock;
    public static MobDuplicatorBlock mobDuplicatorBlock;
    public static BlockDestroyerBlock blockDestroyerBlock;
    public static BlockPlacerBlock blockPlacerBlock;
    public static TreeFluidExtractorBlock treeFluidExtractorBlock;
    public static LatexProcessingUnitBlock latexProcessingUnitBlock;
    public static SewageCompostSolidiferBlock sewageCompostSolidiferBlock;
    public static AnimalByproductRecolectorBlock animalByproductRecolectorBlock;
    public static SludgeRefinerBlock sludgeRefinerBlock;
    public static MobDetectorBlock mobDetectorBlock;
    public static LavaFabricatorBlock lavaFabricatorBlock;
    public static BioReactorBlock bioReactorBlock;
    public static BiofuelGeneratorBlock biofuelGeneratorBlock;
    public static LaserBaseBlock laserBaseBlock;
    public static LaserDrillBlock laserDrillBlock;
    public static OreProcessorBlock oreProcessorBlock;
    public static BlackHoleControllerBlock blackHoleControllerBlock;
    public static DyeMixerBlock dyeMixerBlock;
    public static EnchantmentInvokerBlock enchantmentInvokerBlock;
    public static SporesRecreatorBlock sporesRecreatorBlock;

    public static IFCustomFluidBlock BLOCK_ESSENCE;
    public static IFCustomFluidBlock BLOCK_MILK;
    public static IFCustomFluidBlock BLOCK_MEAT;
    public static IFCustomFluidBlock BLOCK_LATEX;
    public static IFCustomFluidBlock BLOCK_SEWAGE;
    public static IFCustomFluidBlock BLOCK_SLUDGE;
    public static IFCustomFluidBlock BLOCK_BIOFUEL;

    public static void registerBlocks(IForgeRegistry<Block> block, IForgeRegistry<Item> item, IForgeRegistry<IRecipe> recipe) {
        (petrifiedFuelGeneratorBlock = new PetrifiedFuelGeneratorBlock()).register(block, item);
        (enchantmentRefinerBlock = new EnchantmentRefinerBlock()).register(block, item);
        (enchantmentExtractorBlock = new EnchantmentExtractorBlock()).register(block, item);
        (enchantmentAplicatorBlock = new EnchantmentAplicatorBlock()).register(block, item);
        (mobRelocatorBlock = new MobRelocatorBlock()).register(block, item);
        (potionEnervatorBlock = new PotionEnervatorBlock()).register(block, item);
        (animalIndependenceSelectorBlock = new AnimalIndependenceSelectorBlock()).register(block, item);
        (animalStockIncreaserBlock = new AnimalStockIncreaserBlock()).register(block, item);
        (cropSowerBlock = new CropSowerBlock()).register(block, item);
        (cropEnrichMaterialInjectorBlock = new CropEnrichMaterialInjectorBlock()).register(block, item);
        (cropRecolectorBlock = new CropRecolectorBlock()).register(block, item);
        (blackHoleUnitBlock = new BlackHoleUnitBlock()).register(block, item);
        (waterCondensatorBlock = new WaterCondensatorBlock()).register(block, item);
        (waterResourcesCollectorBlock = new WaterResourcesCollectorBlock()).register(block, item);
        (animalResourceHarvesterBlock = new AnimalResourceHarvesterBlock()).register(block, item);
        (mobSlaughterFactoryBlock = new MobSlaughterFactoryBlock()).register(block, item);
        (mobDuplicatorBlock = new MobDuplicatorBlock()).register(block, item);
        (blockDestroyerBlock = new BlockDestroyerBlock()).register(block, item);
        (blockPlacerBlock = new BlockPlacerBlock()).register(block, item);
        (treeFluidExtractorBlock = new TreeFluidExtractorBlock()).register(block, item);
        (latexProcessingUnitBlock = new LatexProcessingUnitBlock()).register(block, item);
        (sewageCompostSolidiferBlock = new SewageCompostSolidiferBlock()).register(block, item);
        (animalByproductRecolectorBlock = new AnimalByproductRecolectorBlock()).register(block, item);
        (sludgeRefinerBlock = new SludgeRefinerBlock()).register(block, item);
        (mobDetectorBlock = new MobDetectorBlock()).register(block, item);
        (lavaFabricatorBlock = new LavaFabricatorBlock()).register(block, item);
        (bioReactorBlock = new BioReactorBlock()).register(block, item);
        (biofuelGeneratorBlock = new BiofuelGeneratorBlock()).register(block, item);
        (laserBaseBlock = new LaserBaseBlock()).register(block, item);
        (laserDrillBlock = new LaserDrillBlock()).register(block, item);
        (oreProcessorBlock = new OreProcessorBlock()).register(block, item);
        (blackHoleControllerBlock = new BlackHoleControllerBlock()).register(block, item);
        (dyeMixerBlock = new DyeMixerBlock()).register(block, item);
        (enchantmentInvokerBlock = new EnchantmentInvokerBlock()).register(block, item);
        (sporesRecreatorBlock = new SporesRecreatorBlock()).register(block, item);


        (BLOCK_ESSENCE = new IFCustomFluidBlock(FluidsRegistry.ESSENCE, Material.WATER)).register(block);
        (BLOCK_MILK = new IFCustomFluidBlock(FluidsRegistry.MILK, Material.WATER)).register(block);
        (BLOCK_MEAT = new IFCustomFluidBlock(FluidsRegistry.MEAT, Material.WATER)).register(block);
        (BLOCK_LATEX = new IFCustomFluidBlock(FluidsRegistry.LATEX, Material.WATER)).register(block);
        (BLOCK_SEWAGE = new IFCustomFluidBlock(FluidsRegistry.SEWAGE, Material.WATER)).register(block);
        (BLOCK_SLUDGE = new IFCustomFluidBlock(FluidsRegistry.SLUDGE, Material.WATER)).register(block);
        (BLOCK_BIOFUEL = new IFCustomFluidBlock(FluidsRegistry.BIOFUEL, Material.WATER)).register(block);

        petrifiedFuelGeneratorBlock.createRecipe();
        enchantmentRefinerBlock.createRecipe();
        enchantmentExtractorBlock.createRecipe();
        enchantmentAplicatorBlock.createRecipe();
        mobRelocatorBlock.createRecipe();
        potionEnervatorBlock.createRecipe();
        animalIndependenceSelectorBlock.createRecipe();
        animalStockIncreaserBlock.createRecipe();
        cropSowerBlock.createRecipe();
        cropEnrichMaterialInjectorBlock.createRecipe();
        cropRecolectorBlock.createRecipe();
        blackHoleUnitBlock.createRecipe();
        waterCondensatorBlock.createRecipe();
        waterResourcesCollectorBlock.createRecipe();
        animalResourceHarvesterBlock.createRecipe();
        mobSlaughterFactoryBlock.createRecipe();
        mobDuplicatorBlock.createRecipe();
        blockDestroyerBlock.createRecipe();
        blockPlacerBlock.createRecipe();
        treeFluidExtractorBlock.createRecipe();
        latexProcessingUnitBlock.createRecipe();
        sewageCompostSolidiferBlock.createRecipe();
        animalByproductRecolectorBlock.createRecipe();
        sludgeRefinerBlock.createRecipe();
        mobDetectorBlock.createRecipe();
        lavaFabricatorBlock.createRecipe();
        bioReactorBlock.createRecipe();
        biofuelGeneratorBlock.createRecipe();
        laserBaseBlock.createRecipe();
        laserDrillBlock.createRecipe();
        oreProcessorBlock.createRecipe();
        blackHoleControllerBlock.createRecipe();
        dyeMixerBlock.createRecipe();
        enchantmentInvokerBlock.createRecipe();
        sporesRecreatorBlock.createRecipe();


    }
}
