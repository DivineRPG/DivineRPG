/**
 * DeveloperCapes by Jadar
 * License: MIT License
 * (https://raw.github.com/jadar/DeveloperCapes/master/LICENSE)
 * version 3.3.0.0
 */
package com.jadarstudios.developercapes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.io.ByteStreams;
import com.google.gson.Gson;
import com.google.gson.stream.MalformedJsonException;
import com.jadarstudios.developercapes.user.DefaultUser;
import com.jadarstudios.developercapes.user.GroupUser;
import com.jadarstudios.developercapes.user.IUser;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * This library adds capes for people you specify
 * 
 * @author Jadar
 */
@SideOnly(Side.CLIENT)
public class DevCapes
{
    
    private static DevCapes    instance;
    
    public static final Logger logger = LogManager.getLogger("DevCapes");
    
    /**
     * Gets the DevCapes instance
     */
    public static DevCapes getInstance()
    {
        if (instance == null)
            instance = new DevCapes();
        return instance;
    }
    
    // name->group
    private HashMap<String, IUser>          users;
    // group->cape
    private HashMap<String, ITextureObject> groups;
    
    /**
     * Object constructor.
     */
    private DevCapes()
    {
        this.groups = new HashMap<String, ITextureObject>();
        this.users = new HashMap<String, IUser>();
    }
    
    /**
     * @param groupName
     *            The name of the group that you wish to add
     * @param texture
     *            The {@link ITextureObject} that contains the texture of the
     *            group's cape
     */
    public void addGroup(final String groupName, final ITextureObject texture)
    {
        this.groups.put(groupName, texture);
    }
    
    /**
     * @param groupName
     *            The name of the group that you wish to add
     * @param capeUrl
     *            The URL as a String of the cape that you wish to assign to the
     *            group
     */
    public void addGroup(final String groupName, final String capeUrl)
    {
    	//TODO: Fix this
        //this.addGroup(groupName, new ThreadDownloadImageData(capeUrl, null, new HDImageBuffer()));
    }
    
    /**
     * @param username
     *            The user name of the player that you wish to add to the group
     * @param group
     *            The group that you wish to add the user to
     */
    public void addGroupUser(final String username, final String group)
    {
        IUser user = this.users.get(username);
        if (user == null)
        {
            user = new GroupUser(username, group);
            this.users.put(username, user);
            
            // make sure to call this last
            this.loadCape(username);
        }
    }
    
    /**
     * @param username
     *            The name of the user that you want to give a cape to
     * @param capeUrl
     *            The URL as a String of the cape that you wish to assign to the
     *            user
     */
    public void addSingleUser(final String username, final String capeUrl)
    {
        IUser user = this.users.get(username);
        if (user == null)
        {
            user = new DefaultUser(username, capeUrl);
            this.users.put(username, user);
            this.loadCape(username);
        }
    }
    
    /**
     * @param group
     *            The name of the group whose cape you want to get
     * @return The {@link ITextureObject} that contains the group's cape
     */
    public ITextureObject getGroupTexture(final String group)
    {
        return this.groups.get(group);
    }
    
    /**
     * 
     * @param username
     *            The name of the user that you wish to get
     * @return The {@link IUser} containing the information of the specified
     *         user
     */
    public IUser getUser(final String username)
    {
        return this.users.get(username);
    }
    
    /**
     * @param username
     *            The name of the user that you wish to get the group that they
     *            belong in
     * @return The group that the user is in. Null if the user is not in a group
     */
    public String getUserGroup(final String username)
    {
        return this.isPlayerInGroup(username) ? ((GroupUser) this.users.get(username)).group : null;
    }
    
    /**
     * 
     * @param username
     *            The name of the user that you wish to get the cape that is
     *            assigned to them
     * @return The {@link ITextureObject} that contains the user's cape
     */
    protected ITextureObject getUserTexture(final String username)
    {
        return this.getUser(username).getTexture();
    }
    
    /**
     * 
     * @param username
     *            The name of the user that you wish to see if they are in a
     *            group
     * @return true if the user is in a group
     */
    public boolean isPlayerInGroup(final String username)
    {
        return this.users.containsKey(username) && this.users.get(username) instanceof GroupUser;
    }
    
    /**
     * @param username
     *            The name of the user whose cape you wish to load
     * @return true of the cape was loaded properly
     */
    public boolean loadCape(final String username)
    {
        IUser user = this.users.get(username);
        return Minecraft.getMinecraft().renderEngine.loadTexture(user.getResource(), user.getTexture());
    }
    
    /**
     * @param jsonFile
     *            The {@link File} in Json format that you wish to add
     * @param identifier
     *            A unique Identifier, normally your mod id
     */
    public void registerConfig(final File jsonFile, final String identifier)
    {
        try
        {
            this.registerConfig(new FileInputStream(jsonFile), identifier);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * @param input
     *            An {@link InputStream} containing the Json data that you wish
     *            to add
     * @param identifier
     *            A unique Identifier, normally your mod id
     */
    @SuppressWarnings("unchecked")
    public void registerConfig(final InputStream input, final String identifier)
    {
        try
        {
            String data = new String(ByteStreams.toByteArray(input));
            input.close();
            
            Map<String, Object> groups = new Gson().fromJson(data, Map.class);
            for (Entry<String, Object> e : groups.entrySet())
            {
                final String nodeName = e.getKey();
                final Object obj = e.getValue();
                if (obj instanceof Map)
                {
                    String groupName = nodeName + identifier;
                    Map<String, Object> group = (Map<String, Object>) obj;
                    
                    String capeUrl = (String) group.get("capeUrl");
                    
                    this.addGroup(groupName, capeUrl);
                    
                    ArrayList<String> users = (ArrayList<String>) group.get("users");
                    if (users != null)
                        for (String username : users)
                            this.addGroupUser(username, groupName);
                }
                else if (obj instanceof String)
                    this.addSingleUser(nodeName, (String) obj);
            }
            
        }
        catch (MalformedJsonException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * @param jsonUrl
     *            A {@link URL} that links to the Json file that you want to add
     * @param identifier
     *            A unique Identifier, normally your mod id
     */
    public void registerConfig(final URL jsonUrl, final String identifier)
    {
        try
        {
            this.registerConfig(jsonUrl.openStream(), identifier);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * @param jsonUrl
     *            The URL as a String that links to the Json file that you want
     *            to add
     * @param identifier
     *            A unique Identifier, normally your mod id
     */
    public void registerConfig(final String jsonUrl, final String identifier)
    {
        try
        {
            this.registerConfig(new URL(jsonUrl), identifier);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }
}