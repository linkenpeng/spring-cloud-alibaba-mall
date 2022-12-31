<template>
  <div class="app-container">
    <el-table
      :data="list"
      style="width: 100%">
      <el-table-column
        prop="item_image"
        label="商品图片"
        width="180">
      </el-table-column>
      <el-table-column
        prop="item_name"
        label="商品名"
        width="180">
      </el-table-column>
      <el-table-column
        prop="item_price"
        label="商品价格">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getItemList } from '@/api/item'

export default {
  data() {
    return {
      list: []
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      getItemList().then(response => {
        console.log(response.data)
        this.list = response.data
      })
    }
  }
}
</script>
