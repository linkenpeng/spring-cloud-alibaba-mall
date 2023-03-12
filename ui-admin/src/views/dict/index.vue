<template>
  <div class="app-container">

    <el-table
      :data="list"
      :load="getChildren"
      :tree-props="{children:'children', hasChildren:'has_children'}"
      style="width: 100%"
      row-key="id"
      border
      lazy
    >
      <el-table-column label="名称" >
        <template v-slot:="scope">
          <span>{{scope.row.name}}</span>
        </template>
      </el-table-column>
      <el-table-column label="编码" >
        <template v-slot:="{row}">
          <span>{{row.dict_code}}</span>
        </template>
      </el-table-column>
      <el-table-column prop="value" label="值"></el-table-column>
      <el-table-column prop="gmt_created" label="创建时间"></el-table-column>
    </el-table>

  </div>
</template>

<script>
import dict from '@/api/dict'

export default {
  data() {
    return {
      list: [],
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      dict.getRootData()
        .then(response => {
          this.list = response.data
        })
    },
    getChildren(tree, treeNode, resolve) {
      dict.getChildData(tree.id)
        .then(response => {
          resolve(response.data)
        })
    }
  }
}
</script>
