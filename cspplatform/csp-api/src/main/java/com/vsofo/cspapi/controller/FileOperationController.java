package com.vsofo.cspapi.controller;

import static com.google.common.collect.Lists.newArrayList;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.vsofo.cspcommon.utils.FileUtil;
import com.vsofo.cspcommon.utils.IdWorker;
import com.vsofo.cspcommon.utils.StringUtil;
import com.vsofo.cspmodel.commonmodels.JsonResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 文件操作 公有控制器 【注意：做集群需独立部署】
 */
@Api(tags = "文件操作控制器")
@RestController
@RequestMapping("fileoperation")
public class FileOperationController {

    @Value("${upload.file.basepath:/file}")
    private String uploadFileBasePath;
    @Value("${upload.file.allowExtentionName}")
    private String[] allowUploadFileExtentionName;
    
    @Autowired
    HttpServletRequest request;
    @Autowired
    IdWorker idWorker;

    @ApiOperation("单文件上传")
    @PostMapping("upload/onefile")
    public JsonResult<String> UploadOneFile(
            @RequestParam(required = true) @ApiParam(value = "分组名称", required = true) String groupname,
            @RequestParam(required = true) @ApiParam(value = "单个文件", required = true) MultipartFile file)
            throws IllegalStateException, IOException {
        String newFileName = file.getOriginalFilename();
        if (allowUploadFileExtentionName == null || allowUploadFileExtentionName.length == 0) {
            // 可上传所有类型文件
        } else {
            String suffixName = FileUtil.GetExtensionNameNoDot(newFileName);
            if (!newArrayList(allowUploadFileExtentionName).contains(suffixName)) {
                return JsonResult.failed("无法上传该类型文件", "");
            }
            newFileName = idWorker.nextId() + "." + suffixName;
        }

        String groupName = StringUtil.IsNullOrEmptyStrAndReturnDefaultValue(groupname, "default");
        String relativeDirectoryPath = FileUtil.CombinePath(uploadFileBasePath, groupName);
        String absoluteDirectoryPath = FileUtil.CombinePath(FileUtil.GetApplicationCurrentPath(),
                relativeDirectoryPath);

        if (!new File(absoluteDirectoryPath).exists()) {
            new File(absoluteDirectoryPath).mkdirs();
        }

        String relativeFilePath = FileUtil.CombinePath(relativeDirectoryPath, newFileName);
        String absoluteFilePath = FileUtil.CombinePath(FileUtil.GetApplicationCurrentPath(), relativeFilePath);

        file.transferTo(new File(absoluteFilePath));

        return JsonResult.success(StringUtil.ChangeRelativeFilePathToUrlPath(relativeFilePath));
    }

    @ApiOperation("多文件上传")
    @PostMapping("upload/multipartfile")
    public JsonResult<String> UploadMultipartFile(
            @RequestParam(required = false) @ApiParam(value = "分组名称", required = true) String groupname,
            @RequestParam(required = true) @ApiParam(value = "多个文件", required = true) List<MultipartFile> files) {

        // 异步

        return JsonResult.success("su");
    }
}
