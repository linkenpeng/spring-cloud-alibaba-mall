<template>
  <div class="app-container">

    <el-form :inline="true" class="demo-form-inline">
      <el-form-item label="商品名称">
        <el-input v-model="searchObj.item_name" placeholder="商品名称"></el-input>
      </el-form-item>
      <el-form-item label="价格大于">
        <el-input v-model="searchObj.low_price" placeholder="价格大于"></el-input>
      </el-form-item>
      <el-form-item label="价格小于">
        <el-input v-model="searchObj.high_price" placeholder="价格小于"></el-input>
      </el-form-item>
      <el-form-item label="商品分类">
        <el-select v-model="searchObj.category_id" placeholder="商品分类">
          <el-option label="选择分类"></el-option>
          <el-option label="水果" value="1"></el-option>
          <el-option label="化妆品" value="2"></el-option>
          <el-option label="服装" value="3"></el-option>
        </el-select>
      </el-form-item>
      <el-button type="primary" icon="el-icon-search" @click="fetchData(current)">查询</el-button>
    </el-form>


    <el-table :data="list" style="width: 100%">

      <el-table-column prop="item_image" label="商品图片" width="180">
        <template slot-scope="scope">
          <img :src="scope.row.item_image" alt="" style="width: 100px;height: 100px">
        </template>
      </el-table-column>

      <el-table-column prop="item_name" label="商品名" width="180"></el-table-column>
      <el-table-column prop="item_price" label="商品价格"></el-table-column>
      <el-table-column prop="item_category.name" label="商品分类"></el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="danger" icon="el-icon-delete" circle @click="removeDataById(scope.row.id)"></el-button>
        </template>
      </el-table-column>


    </el-table>

    <el-pagination
      :current-page="current"
      :page-size="size"
      :total="total"
      background
      layout="total, prev, pager, next, jumper"
      style="margin-top: 10px;text-align: center;"
      @current-change="fetchData"
      >
    </el-pagination>

  </div>
</template>

<script>
import item from '@/api/item'

export default {
  data() {
    return {
      current: 1,
      size: 3,
      searchObj: {},
      list: [],
      total: 0
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData(nowPage=1) {
      item.getItemList(nowPage, this.size, this.searchObj)
        .then(response => {
        this.list = response.data.list
        this.total = response.data.total
      })
    },
    removeDataById(id) {

      this.$confirm('确认删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        item.deleteById(id)
          .then(response => {
            //提示
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
            //刷新页面
            this.fetchData(1)
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });




    }
  }
}
</script>
