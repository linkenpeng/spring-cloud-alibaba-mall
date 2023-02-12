<template>
  <div class="app-container">
    <el-form ref="form" :model="itemData" label-width="80px">
      <el-form-item label="商品名称">
        <el-input v-model="itemData.item_name"></el-input>
      </el-form-item>

      <el-form-item label="商品分类">
        <el-select v-model="itemData.category_id" placeholder="请选择商品分类">
          <el-option label="选择分类"></el-option>
          <el-option v-for="category in category_list"
                     :label="category.name" :value="category.id">
          </el-option>
        </el-select>
      </el-form-item>

      <el-form-item label="商品描述">
        <el-input type="textarea" v-model="itemData.item_desc"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="saveItem">保存</el-button>
        <router-link :to="'/item/list/'">
          <el-button style="margin-left: 10px;">取消</el-button>
        </router-link>
      </el-form-item>

    </el-form>
  </div>
</template>

<script>
import item from '@/api/item'

export default {
  data() {
    return {
      itemData: {},
      category_list: []
    }
  },
  created() {
    this.fetchData()

    if(this.$route.params && this.$route.params.id) {
      const id = this.$route.params.id
      this.getItemById(id)
    }
  },
  methods: {
    fetchData() {
      item.getAllCategory().then(response => {
        this.category_list = response.data
      });
    },

    getItemById(id) {
      item.getItemById(id).then(response => {
        this.itemData = response.data
      });
    },

    saveItem() {
      if(this.itemData.id) {
        item.updateItem(this.itemData)
          .then(response => {
            this.$message({
              type: 'success',
              message: '修改成功!'
            })
            this.$router.push({path:"/item/list"})
          })
      } else {
        item.saveItem(this.itemData)
          .then(response => {
            this.$message({
              type: 'success',
              message: '保存成功!'
            })
            this.$router.push({path:"/item/list"})
          })
      }
    }
  }
}

</script>
