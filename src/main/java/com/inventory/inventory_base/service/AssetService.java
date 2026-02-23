package com.inventory.inventory_base.service.impl;

import com.inventory.inventory_base.model.Asset;
import java.util.List;

public interface AssetService {
    Asset addAsset(Asset asset);
    Asset updateAsset(Long id, Asset asset);
    List<Asset> getAllAssets();
    List<Asset> getAssetsByWarehouse(Long warehouseId);
    void deleteAsset(Long id);
}
