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

    <div>
      <el-button type="danger" size="mini" @click="removeDataByIdList()">批量删除</el-button>
    </div>

    <el-table :data="list" @selection-change="handleSelectionChange" style="width: 100%">

      <el-table-column type="selection" width="50"></el-table-column>

      <el-table-column prop="item_image" label="商品图片" >
        <template slot-scope="scope">
          <img :src="scope.row.item_image" alt="" style="width: 100px;height: 100px">
        </template>
      </el-table-column>

      <el-table-column prop="item_name" label="商品名" ></el-table-column>
      <el-table-column prop="item_price" label="商品价格"></el-table-column>
      <el-table-column prop="item_category.name" label="商品分类"></el-table-column>
      <el-table-column prop="status" label="上架状态">
        <template slot-scope="scope">
          {{scope.row.status === 1 ? "上架" : "下架"}}
        </template>
      </el-table-column>

      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="danger" icon="el-icon-delete"  @click="removeDataById(scope.row.id)">删除</el-button>
          <el-button type="primary" v-if="scope.row.status == 0" icon="el-icon-delete"  @click="changeStatus(scope.row.id, 1)">上架</el-button>
          <el-button type="danger" v-if="scope.row.status == 1" icon="el-icon-delete"  @click="changeStatus(scope.row.id, 0)">下架</el-button>
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
      total: 0,
      multiSelection: []
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
    },

    removeDataByIdList() {
      this.$confirm('确认批量删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let idList = []
        for(let i = 0; i < this.multiSelection.length; i++) {
          let obj = this.multiSelection[i];
          let id = obj.id;
          idList.push(id)
        }
        item.deleteByIdList(idList)
          .then(response => {
            //提示
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
            //刷新页面
            this.fetchData(1)
          })
      })
    },

    changeStatus(id, status) {
      item.changeStatus(id, status)
        .then(response => {
          this.fetchData(1)
        })
    },

    handleSelectionChange(selection) {
      this.multiSelection = selection
    }
  }
}
</script>
