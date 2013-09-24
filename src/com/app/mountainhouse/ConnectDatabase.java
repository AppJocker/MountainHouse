package com.app.mountainhouse;

import redis.clients.jedis.Jedis;

public class ConnectDatabase {
	Jedis jedis;
	String IP = "61.220.118.247";
	
	/**
	 * Create connect to database.
	 * @return
	 */
	public boolean createconnect()
	{
		try
		{
			jedis = new Jedis(IP);
			jedis.connect();
			return true;
		} catch (Exception e)
		{
			return false;
		}
	}
	
	/**
	 * register a new member
	 * @param type, type = 0 FB, type = 1 G+, type = 2 etc.
	 * @param ID, get from FB or G+.
	 * @param Name, get from FB or G+.
	 * @return 0 = fail, 1 = success and then set player name, 2 = already exists and then get player name
	 */
	public int login(int type, String ID, String Name)
	{
		if(type > 1 || ID == null || ID == "")
			return 0;
		
		String keyID = type + ":" + ID;
		
		if(jedis.hexists(keyID, "Name"))
			return 2;
		else
		{
			jedis.hset(keyID, "Name", Name);
			return 1;
		}
	}
	
	/**
	 * Check & Get Player name in game
	 * @param type
	 * @param ID
	 * @return null = fail, other = Player name
	 */
	public String getplayername(int type, String ID)
	{
		if(type > 1 || ID == null || ID == "")
			return null;
		
		String keyID = type + ":" + ID;
		if(jedis.hexists(keyID, "PlayerName"))
			return jedis.hget(keyID, "PlayerName");
		else
			return null;
	}
	
	/**
	 * Set Player Name
	 * @param type
	 * @param ID
	 * @param PlayerName
	 * @return 0 = fail, 1 = success
	 */
	public int setplayername(int type, String ID, String PlayerName)
	{
		if(type > 1 || ID == null || ID == "" || PlayerName == null || PlayerName == "")
			return 0;
		
		String keyID = type + ":" + ID;
		if(jedis.hexists(keyID, "PlayerName"))
			return 2;
		else
		{
			jedis.hset(keyID, "PlayerName", PlayerName);
			return 1;
		}
	}
}
