package net.darkhax.nightmares.entity.render;

import org.lwjgl.opengl.GL11;

import net.darkhax.bookshelf.client.model.ModelPlayerMob;
import net.darkhax.bookshelf.client.rendering.RenderPlayerMob;
import net.darkhax.nightmares.entity.EntityShadow;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.Profile;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderShadow extends RenderPlayerMob<EntityShadow> {

    public static final ResourceLocation TEXTURE = new ResourceLocation("nightmares", "textures/entity/shadow.png");

    public RenderShadow (RenderManager renderManager) {

        //TODO randomize player model
        super(renderManager, new ModelPlayerMob(0.5f, false));
        this.setBlendProfile(Profile.TRANSPARENT_MODEL);
    }

    @Override
    protected ResourceLocation getEntityTexture (EntityShadow entity) {

        return TEXTURE;
    }
    
    @Override
    public void setOverlayVisibility (EntityShadow entity, ModelPlayerMob model) {

        model.bipedHeadwear.showModel = true;
        model.bodyOverlay.showModel = false;
        model.leftLegOverlay.showModel = false;
        model.rightLegLverlay.showModel = false;
        model.leftArmOverlay.showModel = false;
        model.rightArmOverlay.showModel = false;
    }
    
    public static class Factory implements IRenderFactory<EntityShadow> {

        @Override
        public Render<? super EntityShadow> createRenderFor (RenderManager manager) {

            return new RenderShadow(manager);
        }
    }
}