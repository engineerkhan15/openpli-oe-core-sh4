FILESEXTRAPATHS_append := "${THISDIR}/files"

SRC_URI_append_sh4 = " \
    file://fix-makefile.patch \
"
