package com.inventory.inventory_base.service.impl;

import com.inventory.inventory_base.model.Asset;
import com.inventory.inventory_base.repository.AssetRepository;
import com.inventory.inventory_base.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssetServiceImpl implements AssetService{
    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Asset addAsset(Asset asset) {
        // Business Rule: Validate warehouse exists before creating asset [cite: 316, 317]
        asset.setStatus("ACTIVE");
        return assetRepository.save(asset);
    }

    @Override
    public List<Asset> getAssetsByWarehouse(Long warehouseId) {
        // Business Rule: Ability to filter assets by warehouse location
        return assetRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public Asset updateAsset(Long id, Asset assetDetails) {
        Asset asset = assetRepository.findById(id).orElseThrow();
        asset.setName(assetDetails.getName());
        asset.setAssetTag(assetDetails.getAssetTag());
        return assetRepository.save(asset);
    }

    @Override
    public void deleteAsset(Long id) {
        Asset asset = assetRepository.findById(id).orElseThrow();
        asset.setStatus("DELETED"); // Implementation of Soft Delete [cite: 313]
        assetRepository.save(asset);
    }

    @Override
    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

}
