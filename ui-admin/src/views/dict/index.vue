<template>
  <div class="app-container">
    <div class="el-toolbar">
      <div class="el-toolbar-body" style="justify-content: flex-start;">
        <a href="http://localhost:2000/dict/exportData" target="_blank">
          <el-button type="text"><i class="fa fa-plus" />导出</el-button>
        </a>
        <el-button type="text" @click="importData"><i class="fa fa-plus" />导入</el-button>
      </div>
    </div>

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


    <el-dialog
      title="导入"
      :visible.sync="dialogVisible"
      width="30%">

      <el-form :model="ruleForm" status-icon :rules="rules"
               ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="文件">
          <el-upload
            class="upload-demo"
            action="http://localhost:2000/dict/importData"
            multiple="false"
            on-success="onUploadSuccess"
            >
            <el-button size="small" type="primary">点击上传</el-button>
            <div class="el-upload__tip">只能上传excel文件，且不超过500kb</div>
          </el-upload>

        </el-form-item>
      </el-form>


          <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
          </span>

    </el-dialog>

  </div>
</template>

<script>
import dict from '@/api/dict'

export default {
  data() {
    return {
      list: [],
      dialogVisible: false,
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
    },
    importData() {
      this.dialogVisible = true
    },
    onUploadSuccess() {
      this.dialogVisible = false
      this.fetchData()
    },
  }
}
</script>
