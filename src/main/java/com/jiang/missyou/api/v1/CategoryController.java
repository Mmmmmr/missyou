package com.jiang.missyou.api.v1;

import com.jiang.missyou.exception.http.NotFoundException;
import com.jiang.missyou.model.Category;
import com.jiang.missyou.model.GridCategory;
import com.jiang.missyou.service.CategoryService;
import com.jiang.missyou.service.GridCategoryService;
import com.jiang.missyou.vo.CategoriesAllVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("category")
@RestController
@ResponseBody
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private GridCategoryService gridCategoryService;

    @GetMapping("all")
    public CategoriesAllVO getAll(){
        Map<Integer, List<Category>> categroies = categoryService.getAll();
        return new CategoriesAllVO(categroies);
    }

    @GetMapping("grid/all")
    public List<GridCategory> getGridCategoryList() {
        List<GridCategory> gridCategoryList = gridCategoryService.findAll();
        if(gridCategoryList.isEmpty()) {
            throw new NotFoundException(30009);
        }
        return gridCategoryList;
    }
}
