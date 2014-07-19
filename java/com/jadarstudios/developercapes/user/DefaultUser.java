/**
 * DeveloperCapes by Jadar
 * License: MIT License
 * (https://raw.github.com/jadar/DeveloperCapes/master/LICENSE)
 * version 3.3.0.0
 */
package com.jadarstudios.developercapes.user;

import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.util.ResourceLocation;

import com.jadarstudios.developercapes.HDImageBuffer;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * This class is used by DevCapes as a default implementation of {@link IUser}
 * 
 * @author Jadar
 */
@SideOnly(Side.CLIENT)
public class DefaultUser implements IUser
{
    
    public final String      username;
    private ITextureObject   texture;
    private ResourceLocation resource;
    
    /**
     * @param name
     *            The name of the user
     */
    public DefaultUser(final String name)
    {
        this(name, "");
    }
    
    /**
     * 
     * @param name
     *            The name of the user
     * @param capeUrl
     *            The URL as a String of the user's cape
     */
    public DefaultUser(final String name, final String capeUrl)
    {
        this.username = name;
        this.resource = new ResourceLocation("cloaks/" + name);
        //TODO: Fix this
        //this.texture = new ThreadDownloadImageData(capeUrl, null, new HDImageBuffer());
    }
    
    @Override
    public ResourceLocation getResource()
    {
        return this.resource;
    }
    
    @Override
    public ITextureObject getTexture()
    {
        return this.texture;
    }
}