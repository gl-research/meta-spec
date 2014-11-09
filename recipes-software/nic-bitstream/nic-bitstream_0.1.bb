SUMMARY = "Provides wr_nic_dio.bin bitstream for wr-nic over spec"

LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit module

PR = "r0"
PV = "0.1"


SRC_URI = "http://www.ohwr.org/attachments/download/2687/wr_nic_dio.bin-2014-02-14"
SRC_URI[md5sum] = "371f22659e5acf8612e7e11c1481abf6"

S = "${WORKDIR}/"

FILES_${PN} += "/lib/firmware/fmc"

do_compile() {
    :
}

do_install() {
             install -d ${D}/lib/firmware/fmc
             install -m 0755 ${S}/wr_nic_dio.bin-2014-02-14 ${D}/lib/firmware/fmc/wr_nic_dio.bin
}



# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
