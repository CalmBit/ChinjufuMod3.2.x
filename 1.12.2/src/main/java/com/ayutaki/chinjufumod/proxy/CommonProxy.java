package com.ayutaki.chinjufumod.proxy;

import net.minecraft.client.model.ModelBiped;

/* プロキシインターフェイスを使って、クライアントプロキシを書く
 * Write a CommonProxy using ProxyInterface. */
public class CommonProxy implements ProxyInterface {

	/* エンティティの登録、コンフィグ読込など
	* Register Entity and Config. */
	@Override
	public void preInit() { }

	/* レシピ・鉱石などの追加 Register Recipe and Ore. */
	@Override
	public void init() { }

	/* 他Modとの連携 Cooperation with other Mod. */
	@Override
	public void postInit() { }

	/* シングルプレイかどうか Single play or not? */
	@Override
	public boolean isSinglePlayer() {
		return false;
	}

	/* サーバープレイかどうか Sever play or not? */
	@Override
	public boolean isDedicatedServer() {
		return true;
	}

	public ModelBiped getArmorModel(int id) {
		return null;
	}

	public void registerEntityRender() { }

}
