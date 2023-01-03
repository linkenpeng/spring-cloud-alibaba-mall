<template>
  <div class="app-container">
    <el-table
      :data="list"
      style="width: 100%">
      <el-table-column
        prop="item_image"
        label="商品图片"
        width="180">
        <template slot-scope="scope">
          <img :src="scope.row.item_image" alt="" style="width: 100px;height: 100px">
        </template>
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
import { getItemList } from '@/api/item'

export default {
  data() {
    return {
      current: 1,
      size: 2,
      searchObj: {},
      list: [],
      total: 0
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData(page=1) {
      this.current = page
      getItemList(this.current, this.size, this.searchObj).then(response => {
        console.log(response.data)
        this.list = response.data.list
        this.total = response.data.total
      })
    }
  }
}
</script>
