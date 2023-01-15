<template>
  <div class="app-container">
    <el-form ref="form" :model="skuData" label-width="80px">
      <el-input type="hidden" v-model="itemData.id"></el-input>

      <el-form-item label="商品名称">
        <div>{{itemData.item_name}}</div>
      </el-form-item>

      <el-form-item label="SKU名称">
        <el-input v-model="skuData.sku_name"></el-input>
      </el-form-item>

      <el-form-item label="SKU价格">
        <el-input v-model="skuData.sku_price"></el-input>
      </el-form-item>

      <el-form-item label="SKU库存">
        <el-input v-model="skuData.sku_stock"></el-input>
      </el-form-item>

      <el-form-item label="是否上架">
        <el-switch v-model="skuData.status"
          active-color="#13ce66" inactive-color="#ff4949"
          :active-value="1" :inactive-value="0">
        </el-switch>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="saveSku">保存</el-button>
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
      skuData: {},
      category_list: []
    }
  },
  created() {
    this.fetchData()

    if(this.$route.params && this.$route.params.id) {
      const id = this.$route.params.id
      this.getItemById(id)
    }

    if(this.$route.params && this.$route.params.skuid) {
      const skuid = this.$route.params.skuid
      this.getSkuById(skuid)
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

    getSkuById(id) {
      item.getSkuById(id).then(response => {
        this.skuData = response.data
      });
    },

    saveSku() {
      if(this.skuData.id) {
        item.updateSku(this.skuData)
          .then(response => {
            this.$message({
              type: 'success',
              message: '修改成功!'
            })
            this.$router.push({path:"/item/list"})
          })
      } else {
        item.saveSku(this.skuData)
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
