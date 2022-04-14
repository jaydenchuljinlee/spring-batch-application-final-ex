package com.example.springbatch.batch.rowmapper;

import com.example.springbatch.batch.domain.ProductVO;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductVO> {


    @Override
    public ProductVO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ProductVO.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .price(rs.getInt("price"))
                .type(rs.getString("type"))
                .build();
    }
}
