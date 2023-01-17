package com.fossil.fossil.client;

import com.fossil.fossil.block.ModBlocks;
import com.fossil.fossil.block.entity.ModBlockEntities;
import com.fossil.fossil.client.gui.*;
import com.fossil.fossil.client.model.AnuStatueModel;
import com.fossil.fossil.client.particle.BubbleParticle;
import com.fossil.fossil.client.particle.TarBubbleParticle;
import com.fossil.fossil.client.renderer.blockentity.*;
import com.fossil.fossil.client.renderer.entity.RenderPrehistoricGeo;
import com.fossil.fossil.client.renderer.entity.TarSlimeRenderer;
import com.fossil.fossil.entity.ModEntities;
import com.fossil.fossil.inventory.ModMenus;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;

public class ClientInit {
    public static void immediate() {
        EntityRendererRegistry.register(ModEntities.THERIZINOSAURUS,
            context -> new RenderPrehistoricGeo<>(context, "therizinosaurus.geo.json", "fa.therizinosaurus.animations.json", 1, 1));
        EntityRendererRegistry.register(ModEntities.TRICERATOPS,
            context -> new RenderPrehistoricGeo<>(context, "triceratops.geo.json", "triceratops.animation.json", 3, 3));

        EntityRendererRegistry.register(ModEntities.ANU_STATUE,
                context -> new com.fossil.fossil.client.renderer.entity.AnuStatueRenderer(context, new AnuStatueModel()));
        EntityRendererRegistry.register(ModEntities.TAR_SLIME, TarSlimeRenderer::new);
        ParticleProviderRegistry.register(ModBlockEntities.BUBBLE, BubbleParticle.Provider::new);
        ParticleProviderRegistry.register(ModBlockEntities.TAR_BUBBLE, TarBubbleParticle.Provider::new);
    }

    public static void later() {
        RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.BENNETTITALES_SMALL.get());
        RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.BENNETTITALES_TALL.get());
        RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.AMPHORA_VASE_DAMAGED.get());
        RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.KYLIX_VASE_DAMAGED.get());
        RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.VOLUTE_VASE_DAMAGED.get());

        RenderTypeRegistry.register(RenderType.translucent(), ModBlocks.CORDAITES_DOOR.get());
        RenderTypeRegistry.register(RenderType.translucent(), ModBlocks.CORDAITES_TRAPDOOR.get());
        RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.CORDAITES_LEAVES.get());
        RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.SLIME_TRAIL.get());
        RenderTypeRegistry.register(RenderType.cutout(), ModBlocks.OBSIDIAN_SPIKES.get());
        RenderTypeRegistry.register(RenderType.translucent(), ModBlocks.ANCIENT_GLASS.get());
        RenderTypeRegistry.register(RenderType.translucent(), ModBlocks.REINFORCED_GLASS.get());
        RenderTypeRegistry.register(RenderType.translucent(), ModBlocks.CULTIVATE.get());
        MenuScreens.register(ModMenus.FEEDER.get(), FeederScreen::new);
        MenuScreens.register(ModMenus.SIFTER.get(), SifterScreen::new);
        MenuScreens.register(ModMenus.CULTIVATE.get(), CultivateScreen::new);
        MenuScreens.register(ModMenus.ANALYZER.get(), AnalyzerScreen::new);
        MenuScreens.register(ModMenus.WORKTABLE.get(), WorktableScreen::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.VASE.get(), VaseRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.ANU_STATUE.get(), AnuStatueRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.ANUBITE_STATUE.get(), AnubiteStatueRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.SARCOPHAGUS.get(), SarcophagusRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.CULTIVATE.get(), CultivateRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntities.ANCIENT_CHEST.get(), AncientChestRenderer::new);
    }
}
