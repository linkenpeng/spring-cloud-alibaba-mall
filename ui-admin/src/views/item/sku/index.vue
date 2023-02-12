<template>
  <div class="app-container">

    <el-table :data="list" @selection-change="handleSelectionChange" style="width: 100%">

      <el-table-column type="selection" width="50"></el-table-column>

      <el-table-column prop="sku_image" label="SKU图片" >
        <template slot-scope="scope">
          <img :src="scope.row.sku_image" alt="" style="width: 100px;height: 100px">
        </template>
      </el-table-column>

      <el-table-column prop="sku_name" label="SKU名称" ></el-table-column>
      <el-table-column prop="sku_price" label="价格"></el-table-column>
      <el-table-column prop="sku_stock" label="库存"></el-table-column>
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
          <router-link :to="'/item/sku/edit/' + scope.row.id">
            <el-button type="primary" icon="el-icon-edit">编辑</el-button>
          </router-link>
        </template>
      </el-table-column>


    </el-table>

  </div>
</template>

<script>
import item from '@/api/item'

export default {
  data() {
    return {
      list: [],
      multiSelection: []
    }
  },
  created() {
    if(this.$route.params && this.$route.params.id) {
      const itemId = this.$route.params.id
      this.fetchData(itemId)
    }
  },
  methods: {
    fetchData(itemId) {
      item.getSkuList(itemId)
        .then(response => {
        this.list = response.data
      })
    },

    removeDataById(id) {
      this.$confirm('确认删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        item.deleteSkuById(id)
          .then(response => {
            //提示
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
            //刷新页面
            if(this.$route.params && this.$route.params.id) {
              const itemId = this.$route.params.id
              this.fetchData(itemId)
            }
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
      item.changeSkuStatus(id, status)
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
