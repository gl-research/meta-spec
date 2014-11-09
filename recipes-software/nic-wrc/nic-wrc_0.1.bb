SUMMARY = "Provides wr_nic_dio-wrc.bin LM32 soft processor firmware for wr-nic over spec"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"


SRC_URI = "http://www.ohwr.org/attachments/download/2688/wr_nic_dio-wrc.bin-2014-02-14"
SRC_URI[md5sum] = "b612220a0704d78d38fdc4ceed2094d3"

S = "${WORKDIR}/"

FILES_${PN} += "/lib/firmware/fmc"

do_compile() {
    :
}

do_install() {
             install -d ${D}/lib/firmware/fmc
             install -m 0755 ${S}/wr_nic_dio-wrc.bin-2014-02-14 ${D}/lib/firmware/fmc/wr_nic_dio-wrc.bin
}



# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
