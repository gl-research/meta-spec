
SUMMARY = "Minimal image including full spec-sw and spec-getting-started support"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit core-image

IMAGE_FEATURES += "ssh-server-dropbear"

IMAGE_INSTALL += " \
	spec-sw \
	spec-init \
	nic-bitstream \
	nic-wrc \
	spec-library \
	demo-dio \
	demo-user \
	demo-python \
	python-ctypes \
"

export IMAGE_BASENAME = "spec-image-minimal"

